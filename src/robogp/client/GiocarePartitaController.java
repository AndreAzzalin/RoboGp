package robogp.client;

import connection.Connection;
import connection.Message;
import connection.MessageObserver;
import connection.PartnerShutDownException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import robogp.cards.Card;
import robogp.client.gui.GuiGiocare;
import robogp.robodrome.RobodromeToHashMap;
import robogp.logic.Logic;
import robogp.matchmanager.RobotMatch;
import robogp.matchmanager.IniziarePartitaController;
import robogp.matchmanager.Match;
import robogp.matchmanager.RobotMarker;
import robogp.robodrome.Direction;
import robogp.robodrome.Robodrome;
import robogp.robodrome.view.RobodromeAnimationObserver;
import robogp.robodrome.view.RobodromeView;

public class GiocarePartitaController implements MessageObserver, RobodromeAnimationObserver {

    private RobodromeView rv;
    private Logic logic;

    private ArrayList<RobotMatch> robotMatchList;
    private String nickname;

    private Connection connToServer;

    private final ArrayList<RobotMatch> RobotMatchList;

    /* Gestione Pattern Singleton */
    private static GiocarePartitaController singleInstance;
    private final IniziarePartitaController inizPartCtrl;
    private HashMap<String, Connection> playersConnections;
    private CardChooser cardChooserRb1;
    private CardChooser cardChooserRb2;
    private CardChooser cardChooserRb3;
    private CardChooser cardChooserRb4;
    private RobotMatch robotMatch;
    private GuiGiocare g;
    public String nickName;
    private Card c;

    private GiocarePartitaController() {
        RobotMatchList = new ArrayList<>();
        inizPartCtrl = IniziarePartitaController.getInstance();

    }

    public static GiocarePartitaController getInstance() {
        if (GiocarePartitaController.singleInstance == null) {

            GiocarePartitaController.singleInstance = new GiocarePartitaController();

        }

        return GiocarePartitaController.singleInstance;
    }

    public CardChooser getCardChooserRb1() {
        return cardChooserRb1;
    }

    public CardChooser getCardChooserRb2() {
        return cardChooserRb2;
    }

    public CardChooser getCardChooserRb3() {
        return cardChooserRb3;
    }

    public CardChooser getCardChooserRb4() {
        return cardChooserRb4;
    }

    public ArrayList<RobotMatch> getRobotMatchList() {
        return RobotMatchList;
    }

    //crea hashmap nickName,connessione
    public void setPlayersConnections(HashMap<String, Connection> players) {
        playersConnections = players;
    }

    //aggiunge robot alla partita 
    public void addRobotMatch(RobotMatch robot) {
        RobotMatchList.add(robot);
    }

    //aggiorna lista di robot partecipanti alla partita
    public ArrayList<RobotMatch> updateRobotMatchList(ArrayList<Pair<RobotMatch, Card>> instructionsList) {
        ArrayList<RobotMatch> newRobotMatchList = new ArrayList<>();

        for (int i = 0; i < instructionsList.size(); ++i) {
            newRobotMatchList.add(instructionsList.get(i).getKey());
        }

        return newRobotMatchList;
    }

    //confronta poolpersonale per ogni roboto per eseguire le istruzioni in ordine di priorità
    private List<ArrayList<Pair<RobotMatch, Card>>> makeSingleInstructions() {
        ArrayList<Pair<RobotMatch, Card>> singleInstructions = new ArrayList<>();
        List<ArrayList<Pair<RobotMatch, Card>>> singleIstructionsList = new LinkedList<>();
        ArrayList<RobotMatch> rmList = (ArrayList<RobotMatch>) RobotMatchList.clone();

        while (!rmList.isEmpty()) {
            for (int i = 0; i < rmList.size(); i++) {
                singleInstructions.add(new Pair<>(rmList.get(i),
                        rmList.get(i).getPl().getIstruzioni().get(0)));
                rmList.get(i).getPl().getIstruzioni().remove(0);
            }

            Collections.sort(singleInstructions, new Comparator<Pair<RobotMatch, Card>>() {
                @Override
                public int compare(Pair<RobotMatch, Card> o1, Pair<RobotMatch, Card> o2) {
                    return o1.getValue().getPriority() - o2.getValue().getPriority();
                }
            });

            singleIstructionsList.add(singleInstructions);
            singleInstructions = new ArrayList<>();

            if (rmList.get(0).getPl().getIstruzioni().isEmpty()) {
                rmList.clear();
            }
        }

        return singleIstructionsList;
    }

    //creo connessione tra client e manager partita(non utilizzata, connessioe avviene direttamente nel client)
    public void createConnect(String nickName) throws UnknownHostException, IOException, PartnerShutDownException {
        InetAddress addr = InetAddress.getLocalHost();
        connToServer = Connection.connectToHost(addr, 2222);
        robotMatchList = new ArrayList<>();
        this.nickName = nickName;

        Message msg = new Message(Match.MatchJoinRequestMsg);
        msg.setParameters(new Object[]{nickName});

        connToServer.sendMessage(msg);
        connToServer.addMessageObserver(this);

    }

    //observer messaggio ricevuto
    @Override
    public void notifyMessageReceived(Message msg) {

        //messaggio contenente i robot di tutti i client e il robodromo su cui giocare
        if (msg.getName().equals(Match.MatchStartMsg)) {
            int x, y;
            //index tab
            int tab = 0;
            int rbAvv = 0;

            g = new GuiGiocare(this);
            RobotMarker rm = null;
            RobodromeToHashMap rthm;
            ArrayList<Pair<String, List<RobotMarker>>> robots = (ArrayList<Pair<String, List<RobotMarker>>>) msg.getParameter(0);
            String rbdName = (String) msg.getParameter(1);
            rthm = new RobodromeToHashMap(rbdName);
            rv = new RobodromeView(new Robodrome("robodromes/" + rbdName + ".txt"), 40);
            logic = new Logic(rv);

            //aggiungo observer per le animazioni
            rv.addObserver(this);

            //carico i robot ricevuti dalla lista 
            for (int i = 0; i < robots.size(); ++i) {

                for (int j = 0; j < robots.get(i).getValue().size(); ++j) {
                    rm = robots.get(i).getValue().get(j);
                    x = rthm.getInitialPositions().get(Integer.toString(rm.getDock())).getKey();
                    y = rthm.getInitialPositions().get(Integer.toString(rm.getDock())).getValue();
                    robotMatch = new RobotMatch(rm, x, y);
                    getRobotMatchList().add(robotMatch);
                    robotMatch.setDir(Direction.E);
                    rv.placeRobot(rm, Direction.E, x, y, true);

                    //carico le info dei robot avversari sui pannellini a destra 
                    if (!rm.getOwner().equals(nickName)) {

                        switch (rbAvv) {
                            case 0:
                                g.getRbAvvName1().setText(rm.getName());
                                g.getRbAvvLabel1().setIcon(new javax.swing.ImageIcon(rm.getImage(50)));
                                g.getRbAvvHp1().setText("Punti salute: " + robotMatch.getHp());
                                g.getRbAvvNumVite1().setText("Vite: " + robotMatch.getNumVite());
                                rbAvv++;
                                break;
                            case 1:
                                g.getRbAvvName2().setText(rm.getName());
                                g.getRbAvvLabel2().setIcon(new javax.swing.ImageIcon(rm.getImage(50)));
                                g.getRbAvvHp2().setText("Punti salute: " + robotMatch.getHp());
                                g.getRbAvvNumVite2().setText("Vite: " + robotMatch.getNumVite());
                                rbAvv++;
                                break;
                            case 2:
                                g.getRbAvvName3().setText(rm.getName());
                                g.getRbAvvLabel3().setIcon(new javax.swing.ImageIcon(rm.getImage(50)));
                                g.getRbAvvHp3().setText("Punti salute: " + robotMatch.getHp());
                                g.getRbAvvNumVite3().setText("Vite: " + robotMatch.getNumVite());
                                rbAvv++;
                                break;
                            case 3:
                                g.getRbAvvName4().setText(rm.getName());
                                g.getRbAvvLabel4().setIcon(new javax.swing.ImageIcon(rm.getImage(50)));
                                g.getRbAvvHp4().setText("Punti salute: " + robotMatch.getHp());
                                g.getRbAvvNumVite4().setText("Vite: " + robotMatch.getNumVite());
                                rbAvv++;
                                break;
                            case 4:
                                g.getRbAvvName5().setText(rm.getName());
                                g.getRbAvvLabel5().setIcon(new javax.swing.ImageIcon(rm.getImage(50)));
                                g.getRbAvvHp5().setText("Punti salute: " + robotMatch.getHp());
                                g.getRbAvvNumVite5().setText("Vite: " + robotMatch.getNumVite());
                                rbAvv++;
                                break;
                            case 5:
                                g.getRbAvvName6().setText(rm.getName());
                                g.getRbAvvLabel6().setIcon(new javax.swing.ImageIcon(rm.getImage(50)));
                                g.getRbAvvHp6().setText("Punti salute: " + robotMatch.getHp());
                                g.getRbAvvNumVite6().setText("Vite: " + robotMatch.getNumVite());
                                rbAvv++;
                                break;
                            case 6:
                                g.getRbAvvName7().setText(rm.getName());
                                g.getRbAvvLabel7().setIcon(new javax.swing.ImageIcon(rm.getImage(50)));
                                g.getRbAvvHp7().setText("Punti salute: " + robotMatch.getHp());
                                g.getRbAvvNumVite7().setText("Vite: " + robotMatch.getNumVite());
                                rbAvv++;
                                break;
                        }
                    } else {

                        //enable e configure tab dei  robot personali
                        g.getPersonalRbTab().setTitleAt(tab, rm.getName());
                        g.getPersonalRbTab().setEnabledAt(tab, true);
                        if (g.getPersonalRbTab().getTitleAt(tab).equals(robotMatch.getRobotMarker().getName())) {
                            switch (tab) {
                                case 0:
                                    g.getHpLabelTab1().setText("Punti Salute: " + robotMatch.getHp());
                                    g.getNumViteLabelTab1().setText("Vite: " + robotMatch.getNumVite());
                                    g.getRbIconTab1().setIcon(new javax.swing.ImageIcon(rm.getImage(100)));
                                    cardChooserRb1 = new CardChooser(robotMatch, new Logic(rv), connToServer, g, tab);
                                    cardChooserRb1.setVisible(false);
                                    tab++;
                                    break;
                                case 1:
                                    g.getHpLabelTab2().setText("Punti Salute: " + robotMatch.getHp());
                                    g.getNumViteLabelTab2().setText("Vite: " + robotMatch.getNumVite());
                                    g.getRbIconTab2().setIcon(new javax.swing.ImageIcon(rm.getImage(100)));
                                    cardChooserRb2 = new CardChooser(robotMatch, logic, connToServer, g, tab);
                                    cardChooserRb2.setVisible(false);
                                    tab++;
                                    break;
                                case 2:
                                    g.getHpLabelTab3().setText("Punti Salute: " + robotMatch.getHp());
                                    g.getNumViteLabelTab3().setText("Vite: " + robotMatch.getNumVite());
                                    g.getRbIconTab3().setIcon(new javax.swing.ImageIcon(rm.getImage(100)));
                                    cardChooserRb3 = new CardChooser(robotMatch, logic, connToServer, g, tab);
                                    cardChooserRb3.setVisible(false);
                                    tab++;
                                    break;
                                case 3:
                                    g.getHpLabelTab4().setText("Punti Salute: " + robotMatch.getHp());
                                    g.getNumViteLabelTab4().setText("Vite: " + robotMatch.getNumVite());
                                    g.getRbIconTab4().setIcon(new javax.swing.ImageIcon(rm.getImage(100)));
                                    cardChooserRb4 = new CardChooser(robotMatch, logic, connToServer, g, tab);
                                    cardChooserRb4.setVisible(false);
                                    tab++;
                                    break;
                            }
                        }
                    }
                }
            }

            g.getLogGiocare().append("Fase programmazione avviata\n");

            //visualizza la gui per giocare e carica il robodromo 
            g.getSplitPanel().setRightComponent(rv);
            g.getTitleLabel().setText("Robo Gp Giocatore:  " + nickName);
            g.setVisible(true);

        }

        //nessaggio per il match manager
        if (msg.getName().equals(Match.MatchInstructionsList)) {

            //instruction list è un lista di pair robot,card ordinata per priorità(delle schede)
            List<ArrayList<Pair<RobotMatch, Card>>> instructionsList = (List<ArrayList<Pair<RobotMatch, Card>>>) msg.getParameter(0);

            for (int i = 0; i < instructionsList.size(); ++i) {

                //aggiorno la lista dei robot partecipanti
                robotMatchList = updateRobotMatchList(instructionsList.get(i));

                for (int j = 0; j < instructionsList.get(i).size(); ++j) {
                    logic.setRobots(robotMatchList);
                    c = instructionsList.get(i).get(j).getValue();
                    c.setLogic(logic);
                    c.execute(robotMatchList.get(j));

                    //stampo tutte le istruzioni che verranno eseguite nella manche 
                    g.getLogRbAvversari().append(robotMatchList.get(j).getRobotMarker().getName() + " " + c.getName() + "\n");
                }

                g.getLogRbAvversari().append("\n");

            }

            logic.fireLaser();

            //avvio coda di animazioni
            if (!rv.getAnimationQueue().isEmpty()) {
                rv.play();
            }
        }

        //messaggio per il match manager, riceve lista di carte per ogni robot di ogni client  le ordina e le rispedisce a tutti i client
        if (msg.getName().equals(Match.MatchListCards)) {

            Message replyMsg = new Message(Match.MatchInstructionsList);
            RobotMatch robot = (RobotMatch) msg.getParameter(0);

            this.addRobotMatch(robot);

            if (this.getRobotMatchList().size() == this.inizPartCtrl.getTotalRobotsInPlay()) {
                List<ArrayList<Pair<RobotMatch, Card>>> list = this.makeSingleInstructions();

                for (int i = 0; i < this.inizPartCtrl.getNickPlayers().size(); ++i) {
                    Connection playerConnection = playersConnections.get(this.inizPartCtrl.getNickPlayers().get(i));

                    try {
                        replyMsg.setParameters(new Object[]{list});
                        playerConnection.sendMessage(replyMsg);
                    } catch (PartnerShutDownException ex) {
                        Logger.getLogger(Match.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    //observer inizio animazione
    @Override
    public void animationStarted() {
        g.getLogGiocare().append("Fase esecuzione avviata\n\r");

    }

    //observer fine animazione
    @Override
    public void animationFinished() {

        //Messaggi notifica fine manche per log partita
        g.getLogGiocare().append("Fine manche\n");
        int rbAvv = 0;
        for (RobotMatch robot : robotMatchList) {

            //aggiorno le informazioni delle tab dei robot personali
            if (robot.getRobotMarker().getOwner().equals(nickName)) {
                if (robot.getRobotMarker().getName().equals(g.getPersonalRbTab().getTitleAt(0))) {

                    g.getHpLabelTab1().setText("Punti salute: " + robot.getHp());
                    g.getNumViteLabelTab1().setText("Vite: " + robot.getNumVite());
                } else if (robot.getRobotMarker().getName().equals(g.getPersonalRbTab().getTitleAt(1))) {

                    g.getHpLabelTab2().setText("Punti salute: " + robot.getHp());
                    g.getNumViteLabelTab2().setText("Vite: " + robot.getNumVite());
                } else if (robot.getRobotMarker().getName().equals(g.getPersonalRbTab().getTitleAt(2))) {

                    g.getHpLabelTab3().setText("Punti salute: " + robot.getHp());
                    g.getNumViteLabelTab3().setText("Vite: " + robot.getNumVite());
                } else if (robot.getRobotMarker().getName().equals(g.getPersonalRbTab().getTitleAt(3))) {

                    g.getHpLabelTab4().setText("Punti salute: " + robot.getHp());
                    g.getNumViteLabelTab4().setText("Vite: " + robot.getNumVite());
                }
            } else {

                //aggiorno le informazioni dei robot avversari
                if (robot.getRobotMarker().getName().equals(g.getRbAvvName1().getText())) {
                    g.getRbAvvHp1().setText("Punti salute: " + robot.getHp());
                    g.getRbAvvNumVite1().setText("Vite: " + robot.getNumVite());
                } else if (robot.getRobotMarker().getName().equals(g.getRbAvvName2().getText())) {
                    g.getRbAvvHp2().setText("Punti salute: " + robot.getHp());
                    g.getRbAvvNumVite2().setText("Vite: " + robot.getNumVite());
                } else if (robot.getRobotMarker().getName().equals(g.getRbAvvName3().getText())) {
                    g.getRbAvvHp3().setText("Punti salute: " + robot.getHp());
                    g.getRbAvvNumVite3().setText("Vite: " + robot.getNumVite());
                } else if (robot.getRobotMarker().getName().equals(g.getRbAvvName4().getText())) {
                    g.getRbAvvHp4().setText("Punti Salute: " + robot.getHp());
                    g.getRbAvvNumVite4().setText("Vite: " + robot.getNumVite());
                } else if (robot.getRobotMarker().getName().equals(g.getRbAvvName5().getText())) {
                    g.getRbAvvHp5().setText("Punti salute: " + robot.getHp());
                    g.getRbAvvNumVite5().setText("Vite: " + robot.getNumVite());
                } else if (robot.getRobotMarker().getName().equals(g.getRbAvvName6().getText())) {
                    g.getRbAvvHp6().setText("Punti salute: " + robot.getHp());
                    g.getRbAvvNumVite6().setText("Vite: " + robot.getNumVite());
                } else if (robot.getRobotMarker().getName().equals(g.getRbAvvName7().getText())) {
                    g.getRbAvvHp7().setText("Punti salute: " + robot.getHp());
                    g.getRbAvvNumVite7().setText("Vite: " + robot.getNumVite());
                }

            }

            if (robot.getHp() <= 0) {
                JOptionPane.showMessageDialog(g, "Robot " + robot.getRobotMarker().getName() + " morto, verrà ripiazzato nella manche successsiva");
            }
        }
    }

}
