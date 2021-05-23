package com.proyecto.vista_principal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.proyecto.R;
import com.proyecto.admin.MainAdmin;
import com.proyecto.cliente.MainClient;
import com.proyecto.models.usuario.Usuario;
import com.proyecto.models.usuario.UsuarioLab;

import java.util.List;

public class Login extends AppCompatActivity {
    private UsuarioLab nUsuarioLab;
    public static final String ID_USUARIO = "com.proyecto.vistaPrincipal.idUsuario";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        nUsuarioLab = UsuarioLab.get(this);
    }

    public void loguearse(View view) {
        EditText editUsuario = findViewById(R.id.txtUser);
        EditText editPassword = findViewById(R.id.txtPassword);

        String usuario = editUsuario.getText().toString();
        String password = editPassword.getText().toString();

        List <Usuario> usuarios = nUsuarioLab.getLogin(usuario, password);
        if(usuarios.isEmpty()){
            Toast.makeText(this, "Usuario o contraseña no coinciden", Toast.LENGTH_SHORT).show();
        }else {
            Usuario usuario1 = usuarios.get(0);
            if(usuario1.getUsuario().equals("admin")){
                Intent intent = new Intent(this, MainAdmin.class);
                startActivity(intent);
                Toast.makeText(this, "admin", Toast.LENGTH_SHORT).show();
            }else{
                Intent intent = new Intent(this, MainClient.class);
                intent.putExtra(ID_USUARIO, usuario1.getIdUsuario());
                startActivity(intent);
                Toast.makeText(this, "cliente", Toast.LENGTH_SHORT).show();
            }
        }
    }



    public void enviarRegistro(View view) {
        //Invocar a la tercera actividad
        Intent intent = new Intent(this, RegistroPrincipal.class);
        startActivity(intent);
    }


}