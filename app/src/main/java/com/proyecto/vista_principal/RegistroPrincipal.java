package com.proyecto.vista_principal;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.proyecto.R;
import com.proyecto.models.registro.RegistroLab;
import com.proyecto.models.usuario.UsuarioLab;
import com.proyecto.models.registro.Registro;
import com.proyecto.models.usuario.Usuario;

public class RegistroPrincipal extends AppCompatActivity {
    private RegistroLab nRegistroLab;
    private UsuarioLab nUsuarioLab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        nRegistroLab = RegistroLab.get(this);
        nUsuarioLab = UsuarioLab.get(this);
    }

    public void registrarse (View view){
        EditText editPrimerNombre = findViewById(R.id.txtPrimerNombre);
        EditText editSegundoNombre = findViewById(R.id.txtSegundoNombre);
        EditText editPrimerApellido = findViewById(R.id.txtPrimerApellido);
        EditText editSegundoApellido = findViewById(R.id.txtSegundoApellido);
        EditText editUsuario = findViewById(R.id.txtUserRegistro);
        EditText editPassword = findViewById(R.id.txtPasswordRegistro);
        EditText editCorreo = findViewById(R.id.txtCorreo);
        EditText editCelular = findViewById(R.id.txtCelular);

        String primerNombre = editPrimerNombre.getText().toString();
        String segundoNombre = editSegundoNombre.getText().toString();
        String primerApellido = editPrimerApellido.getText().toString();
        String segundoApellido = editSegundoApellido.getText().toString();
        String usuario = editUsuario.getText().toString();
        String password = editPassword.getText().toString();
        String correo = editCorreo.getText().toString();
        String celularstring = editCelular.getText().toString();

        if (TextUtils.isEmpty(primerNombre) || TextUtils.isEmpty(segundoNombre) || TextUtils.isEmpty(primerApellido)
                || TextUtils.isEmpty(segundoApellido) || TextUtils.isEmpty(usuario) || TextUtils.isEmpty(password) || TextUtils.isEmpty(correo)
                || TextUtils.isEmpty(celularstring)) {
            Toast.makeText(this,"Por favor llene todos los campos.", Toast.LENGTH_LONG).show();
        }else {
            long celular = Long.parseLong(celularstring);

            String idRegistro = insertRegistroBD(primerNombre, segundoNombre, primerApellido, segundoApellido, correo, celular);
            insertUsuarioBD(usuario, password, idRegistro);

            finish();
        }
    }

    private String insertRegistroBD(String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String correo, long celular) {
        Registro nuevoRegistro = new Registro(primerNombre, segundoNombre, primerApellido, segundoApellido, celular, correo);
        nRegistroLab.addRegistro(nuevoRegistro);
        Toast.makeText(this, "Registrado", Toast.LENGTH_SHORT).show();
        return nuevoRegistro.getIdRegistro();
    }
    private void insertUsuarioBD(String usuario, String password, String idRegistroFk) {
        Usuario nuevoUsuario = new Usuario(usuario, password, idRegistroFk);
        nUsuarioLab.addUsuario(nuevoUsuario);
    }
}