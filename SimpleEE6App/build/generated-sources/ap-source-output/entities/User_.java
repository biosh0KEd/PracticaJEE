package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-21T11:33:13")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, Integer> idUser;
    public static volatile SingularAttribute<User, Boolean> autorizacion;
    public static volatile SingularAttribute<User, Boolean> limiteDeProyectos;
    public static volatile SingularAttribute<User, String> usuario;
    public static volatile SingularAttribute<User, String> contrasena;
    public static volatile SingularAttribute<User, Boolean> tipoDeUsuario;

}