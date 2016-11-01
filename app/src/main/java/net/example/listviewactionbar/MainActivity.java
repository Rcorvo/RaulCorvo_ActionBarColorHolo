package net.example.listviewactionbar;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    //Variables e instancias necesarias
    private int cont = 6;
    private ArrayAdapter<String> arrayAdapter;
    private static final String[] items = {"En", "un", "lugar", "de", "la", "Mancha",
            "de", "cuyo", "nombre", "no", "quiero", "acordarme", "no", "ha", "mucho",
            "tiempo", "que", "vivia", "un", "hidalgo", "de", "los", "de", "lanza", "en",
            "astillero", "adarga", "antigua", "rocin", "flaco", "y", "galgo", "corredor"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar().setDisplayShowHomeEnabled(true);

        //Se llama al método que inicializa el adapter y se lo asigna al ListView
        adaptar();
    }

    //Metodo que infla el menú para que se muestre
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return (super.onCreateOptionsMenu(menu));
    }

    //Método que controla el click en cada item del menú
    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){
            //Se aumenta en uno el contador que controla el número de items a mostrar
            case R.id.anyadir:
                cont++;
                adaptar();
                break;
            //Se restablece a 6 el número de items a mostrar
            case R.id.reset:
                cont = 6;
                adaptar();
                break;
            //Muestra un Toast con información sobre la aplicación
            case R.id.acercade:
                Toast.makeText(this, R.string.textoSobre, Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    /*Método el cual define el adaptador. En la propia definición se llama al método que
    devuelve el array con los items a mostrar*/
    protected void adaptar(){

        arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, ItemsAMostrar(items, cont));

        setListAdapter(arrayAdapter);
    }

    /*Método el cual devuelve la lista de datos a mostrar. Se le pasa por parámetro la
    lista completa y la variable que controla el número de items a mostrar*/
    protected String[] ItemsAMostrar(String[] items, int cont){

        //Array que contendrá los items a mostrar. El tamaño se determina por la variable cont
        String[] primerasSeis = new String[cont];

        //Se le añaden al array anterior la cantidad de items correspondiente
        for(int i=0;i<cont;i++){
            primerasSeis[i] = items[i];
        }

        //Se devuelve dicho array
        return primerasSeis;
    }
}
