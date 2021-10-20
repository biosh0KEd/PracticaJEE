package entities;

import entities.Proyecto;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-21T11:33:13")
@StaticMetamodel(Categoria.class)
public class Categoria_ { 

    public static volatile CollectionAttribute<Categoria, Proyecto> proyectoCollection;
    public static volatile SingularAttribute<Categoria, Integer> idCategoria;
    public static volatile SingularAttribute<Categoria, String> nombreCat;

}