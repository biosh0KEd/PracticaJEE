package entities;

import entities.Categoria;
import entities.Userproyecto;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-21T11:33:13")
@StaticMetamodel(Proyecto.class)
public class Proyecto_ { 

    public static volatile SingularAttribute<Proyecto, String> descripcion;
    public static volatile SingularAttribute<Proyecto, Integer> idProyecto;
    public static volatile SingularAttribute<Proyecto, Date> fecha;
    public static volatile SingularAttribute<Proyecto, String> estado;
    public static volatile SingularAttribute<Proyecto, String> enlaceReq;
    public static volatile SingularAttribute<Proyecto, String> enlaceRepT;
    public static volatile SingularAttribute<Proyecto, String> objetivos;
    public static volatile SingularAttribute<Proyecto, String> enlaceCF;
    public static volatile SingularAttribute<Proyecto, String> enlaceInst;
    public static volatile CollectionAttribute<Proyecto, Userproyecto> userproyectoCollection;
    public static volatile SingularAttribute<Proyecto, Categoria> idCategoria;
    public static volatile SingularAttribute<Proyecto, String> nombre;

}