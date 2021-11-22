package Van064886.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class calcultarice extends AppCompatActivity
{

    TextView ecranOp;
    TextView ecranRs;

    String operations = "";

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculatrice);
        initTextViews();
    }

    // Création d'une méthode pour gerer l'affichage des text views
    private void initTextViews()
    {
        ecranOp = (TextView)findViewById(R.id.ecranOp);
        ecranRs = (TextView)findViewById(R.id.ecranRs);
    }

    // Fonction pour gérer les opérations
    private void setOperations(String valeur)
    {
        operations = operations + valeur;
        ecranOp.setText(operations);
    }

    // Gestion des evenements onClick
    public void clearOnClick( View view )
    {
        ecranOp.setText("");
        operations = "";
        ecranRs.setText("");
    }

    public void plusMinusOnClick( View view )
    {
        /*operations = "-" + operations;
        ecranOp.setText(operations);*/

        int negative = Integer.parseInt(operations);
        negative = 0 - negative;
        operations = String.valueOf(negative);
        ecranOp.setText(operations);
    }

    public void moduloOnClick( View view )
    {
        setOperations("%");
    }

    public void divideOnClick( View view )
    {
        setOperations("/");
    }

    public void sevenOnClick( View view )
    {
        setOperations("7");
    }

    public void eightOnClick( View view )
    {
        setOperations("8");
    }

    public void nineOnClick( View view )
    {
        setOperations("9");
    }

    public void multiplyOnClick( View view )
    {
        setOperations("*");
    }

    public void fourOnClick( View view )
    {
        setOperations("4");
    }

    public void fiveOnClick( View view )
    {
        setOperations("5");
    }

    public void sixOnClick( View view )
    {
        setOperations("6");
    }

    public void substractOnClick( View view )
    {
        setOperations("-");
    }

    public void oneOnClick( View view )
    {
        setOperations("1");
    }

    public void twoOnClick( View view )
    {
        setOperations("2");
    }

    public void threeOnClick( View view )
    {
        setOperations("3");
    }

    public void addOnClick( View view )
    {
        setOperations("+");
    }

    public void zeroOnClick( View view )
    {
        setOperations("0");
    }

    public void pointOnClick( View view )
    {
        char[] ch = new char[operations.length()];
        int occurences = 0;

        // Copie des caracteres dans ch
        for (int i = 0; i < operations.length(); i++)
        {
            int comparaison = Character.compare(operations.charAt(i), '.');
            if ( comparaison == 0 )
                occurences++;
        }

        // Verification de l'oocurrence
        if ( occurences == 0 )
            setOperations(".");
    }

    public void equalsOnClick( View view )
    {
        Double resultat = null;
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");

        try
        {
            resultat = (double)engine.eval(operations);
        }
        catch (ScriptException e)
        {
            Toast.makeText(this , "Opération invalide" , Toast.LENGTH_SHORT).show();
        }

        if ( resultat != null )
        {
            ecranRs.setText(String.valueOf(resultat.doubleValue()));
        }
    }
}