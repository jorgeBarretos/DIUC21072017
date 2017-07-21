package ucuenca.tramitesdiuc;

/**
 * This class was automatically generated by the data modeler tool.
 */
import java.text.SimpleDateFormat;
import javax.persistence.Transient;
import java.text.ParseException;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@javax.persistence.Entity
public class presupuesto implements java.io.Serializable
{

   static final long serialVersionUID = 1L;

   @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.AUTO, generator = "PRESUPUESTO_ID_GENERATOR")
   @javax.persistence.Id
   @javax.persistence.SequenceGenerator(sequenceName = "PRESUPUESTO_ID_SEQ", name = "PRESUPUESTO_ID_GENERATOR")
   private java.lang.Long id;

   @javax.persistence.OneToMany(cascade = { javax.persistence.CascadeType.ALL }, fetch = javax.persistence.FetchType.EAGER)
   private java.util.List<ucuenca.tramitesdiuc.rubro> rubros;

   private java.lang.String justificacion;
   
   @Transient
   SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/yyyy");

   private java.lang.String observaciones;

   @Temporal(TemporalType.DATE)
   private java.util.Date fecha_reformulacion;

   private org.jbpm.document.Document presupuestoreformulado;

   public presupuesto()
   {
   }

   public java.lang.Long getId()
   {
      return this.id;
   }

   public void setId(java.lang.Long id)
   {
      this.id = id;
   }

   public java.util.List<ucuenca.tramitesdiuc.rubro> getRubros()
   {
      return this.rubros;
   }

   public void setRubros(java.util.List<ucuenca.tramitesdiuc.rubro> rubros)
   {
      this.rubros = rubros;
   }

   public java.lang.String getJustificacion()
   {
      return this.justificacion;
   }

   public void setJustificacion(java.lang.String justificacion)
   {
      this.justificacion = justificacion;
   }

   public java.lang.String getObservaciones()
   {
      return this.observaciones;
   }

   public void setObservaciones(java.lang.String observaciones)
   {
      this.observaciones = observaciones;
   }

   public java.util.Date getFecha_reformulacion()
   {
      return this.fecha_reformulacion;
   }

   public void setFecha_reformulacion(java.util.Date fecha_reformulacion)
   {
      this.fecha_reformulacion = corregirFecha(fecha_reformulacion);
   }

   public org.jbpm.document.Document getPresupuestoreformulado()
   {
      return this.presupuestoreformulado;
   }

   public void setPresupuestoreformulado(org.jbpm.document.Document presupuestoreformulado)
   {
      this.presupuestoreformulado = presupuestoreformulado;
   }

   public presupuesto(java.lang.Long id,
         java.util.List<ucuenca.tramitesdiuc.rubro> rubros,
         java.lang.String justificacion, java.lang.String observaciones,
         java.util.Date fecha_reformulacion,
         org.jbpm.document.Document presupuestoreformulado)
   {
      this.id = id;
      this.rubros = rubros;
      this.justificacion = justificacion;
      this.observaciones = observaciones;
      this.fecha_reformulacion = corregirFecha(fecha_reformulacion);
      this.presupuestoreformulado = presupuestoreformulado;
   }
   
   public Date corregirFecha(Date fecha){
        if(fecha!=null){
            int anio=Integer.parseInt(formatoFecha.format(fecha).substring(6));
            if(anio<999){
                    anio+=2000;
                    try {
                    fecha=formatoFecha.parse(formatoFecha.format(fecha).substring(0, 6)+anio);
                    } catch (ParseException ex) {
                        System.out.println("error parse: fecha");
                    }
            }   
        }
        return fecha;
   }

}