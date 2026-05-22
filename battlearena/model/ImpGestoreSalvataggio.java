package battlearena.model;
import java.io.*;

public class ImpGestoreSalvataggio implements GestoreSalvataggio{

    File azioni = new File("saves/actions.dat");
    File vincitori = new File("saves/winners.dat");

    @Override
    public void registraAzioneLog(String azione) throws Exception {
        try(OutputStream file = new FileOutputStream(azioni);
            OutputStream bstream = new BufferedOutputStream(file);
            DataOutputStream dstream = new DataOutputStream(bstream);
        ){
            dstream.writeUTF(azione);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void salvaVincitore(String nomePersonaggio) throws Exception {
        try(OutputStream file = new FileOutputStream(vincitori);
            OutputStream bstream = new BufferedOutputStream(file);
            DataOutputStream dstream = new DataOutputStream(bstream);
        ){
            dstream.writeUTF(nomePersonaggio);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
