package br.edu.ifsp.agendasqlite.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import br.edu.ifsp.agendasqlite.R;
import br.edu.ifsp.agendasqlite.data.ContatoDAO;
import br.edu.ifsp.agendasqlite.model.Contato;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cadastro, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_salvarContato) {
            ContatoDAO dao = new ContatoDAO(this);

            String nome = ((EditText) findViewById(R.id.editTextNome)).getText().toString();
            String dataNascimento = ((EditText) findViewById(R.id.editTextDataNascimento)).getText().toString();
            String fone = ((EditText) findViewById(R.id.editTextFone)).getText().toString();
            String email = ((EditText) findViewById(R.id.editTextEmail)).getText().toString();
            Integer favorito = ((Switch) findViewById(R.id.favorito)).isChecked() ? 1 : 0 ;
            String foneContato = ((EditText) findViewById(R.id.editTextFoneContato)).getText().toString();

            Contato c = new Contato(nome, fone, email, favorito, foneContato, dataNascimento);

            int idContato = (int) dao.incluirContato(c);
            c.setId(idContato);
            Log.d("Contato Cadastrado ", c.toString());

            MainActivity.adapter.adicionaContatoAdapter(c);

            Toast.makeText(getApplicationContext(),"Contato inserido",Toast.LENGTH_LONG).show();

            finish();


        }

        return super.onOptionsItemSelected(item);
    }



}
