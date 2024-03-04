package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.models.UsuarioModel;
import com.example.demo.models.Response.GenericResponse;

@Service
public class UsuarioService {

    private ArrayList<UsuarioModel> usuarios = new ArrayList<>();
    private long idCounter = 1;

    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarios;
    }

    public GenericResponse<UsuarioModel> guardarUsuario(UsuarioModel usuario){
        try {
            usuario.setId(idCounter++);
            usuarios.add(usuario);
            return new GenericResponse<>(HttpStatus.OK, "Usuario guardado exitosamente", true, usuario);
        } catch (Exception exception) {
            return new GenericResponse<>(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), false, null);
        }
    }
}
