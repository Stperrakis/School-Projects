/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buzzquizworldui.utilities;

import buzzquizworld.object.model.Game;
import buzzquizworld.object.model.User;
import buzzquizworldui.history.BattleSerializable;
import buzzquizworldui.history.SinglePlayerSerializable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import static sun.text.normalizer.UTF16.append;

/**
 *
 * @author teonapster
 */
public class GameLogger {

    public static String singlePlayerFilePath = "buzzquizworldui/history/singleGame.bin";
    public static String battleFilePath = "buzzquizworldui/history/battleGame.bin";
    public static String folder = "buzzquizworldui/history/";

    public static void LogGame(User user1, User user2) throws FileNotFoundException, IOException {
        URL url = GameLogger.class.getClassLoader().getResource(folder);
        if (user2 == null) {
            File file = new File(url.getPath() + "singleGame.bin");
            ObjectOutputStream out = null;
            if (!file.exists()) {
                out = new ObjectOutputStream(new FileOutputStream(url.getPath() + "singleGame.bin"));
            } else { //avoid ovewrite headers when file exists
                out = new CustomObjectOutputStream(new FileOutputStream(url.getPath() + "singleGame.bin", true));
            }
            SinglePlayerSerializable serUser1 = new SinglePlayerSerializable(user1.getName(), user1.getPoints(), user1.getCorrAnswer());
            out.writeObject(serUser1);
            out.flush();
            out.close();
            return;
        }

        File file = new File(url.getPath() + "battleGame.bin");
        ObjectOutputStream out = null;
        if (!file.exists()) {
            out = new ObjectOutputStream(new FileOutputStream(url.getPath() + "battleGame.bin"));
        } else { //avoid ovewrite headers when file exists
            out = new CustomObjectOutputStream(new FileOutputStream(url.getPath() + "battleGame.bin", true));
        }
        User winner = user2.getPoints() > user1.getPoints() ? user2 : user1;
        User loser = user2.getPoints() > user1.getPoints() ? user1 : user2;
        BattleSerializable battleObj = new BattleSerializable(loser.getName(), winner.getName(), winner.getPoints(), winner.getCorrAnswer());
        out.writeObject(battleObj);
        out.close();
    }

    public static List<SinglePlayerSerializable> readSinglePlayerLogs() throws IOException, ClassNotFoundException {
        // read object from file
        List<SinglePlayerSerializable> results = new ArrayList<SinglePlayerSerializable>();
        URL url = GameLogger.class.getClassLoader().getResource(singlePlayerFilePath);
        if (url == null) {
            return new ArrayList<SinglePlayerSerializable>();
        }
        FileInputStream fis = new FileInputStream(url.getPath());
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(fis);
            while (true) {
                results.add((SinglePlayerSerializable) ois.readObject());
            }
        } catch (OptionalDataException e) {
            if (!e.eof) {
                throw e;
            }
        } catch (EOFException e) {

        } finally {
            if (ois != null) {
                ois.close();
            }
        }

        return results;
    }

    public static List<BattleSerializable> readBattleLogs() throws IOException, ClassNotFoundException {
        // read object from file
        List<BattleSerializable> results = new ArrayList<BattleSerializable>();
        URL url = GameLogger.class.getClassLoader().getResource(battleFilePath);
        if (url == null) {
            return new ArrayList<BattleSerializable>();
        }
        FileInputStream fis = new FileInputStream(url.getPath());
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(fis);
            while (true) {
                results.add((BattleSerializable) ois.readObject());
            }
        } catch (OptionalDataException e) {
            if (!e.eof) {
                throw e;
            }
        } catch (EOFException e) {

        } finally {
            if (ois != null) {
                ois.close();
            }
        }

        return results;
    }

}
