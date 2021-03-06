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
public class oficio implements java.io.Serializable
{

   static final long serialVersionUID = 1L;

   @javax.persistence.GeneratedValue(generator = "OFICIO_ID_GENERATOR", strategy = javax.persistence.GenerationType.AUTO)
   @javax.persistence.Id
   @javax.persistence.SequenceGenerator(sequenceName = "OFICIO_ID_SEQ", name = "OFICIO_ID_GENERATOR")
   private java.lang.Long id;

   @Transient
   SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/yyyy");
   
   private java.lang.String nro_oficio;

   private java.lang.String nro_tramite;

   @Temporal(TemporalType.DATE)
   private java.util.Date fecha_oficio;

   private java.lang.String codigo_ubicacion;

   private java.lang.String observaciones;

   private java.lang.String director_solicitante;

   private String digitalizado;

   private java.lang.String directorio;

   public oficio()
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

   public java.lang.String getNro_oficio()
   {
      return this.nro_oficio;
   }

   public void setNro_oficio(java.lang.String nro_oficio)
   {
      this.nro_oficio = nro_oficio;
   }

   public java.lang.String getNro_tramite()
   {
      return this.nro_tramite;
   }

   public void setNro_tramite(java.lang.String nro_tramite)
   {
      this.nro_tramite = nro_tramite;
   }

   public java.util.Date getFecha_oficio()
   {
      return this.fecha_oficio;
   }

   public void setFecha_oficio(java.util.Date fecha_oficio)
   {
      this.fecha_oficio = corregirFecha(fecha_oficio);
   }

   public java.lang.String getCodigo_ubicacion()
   {
      return this.codigo_ubicacion;
   }

   public void setCodigo_ubicacion(java.lang.String codigo_ubicacion)
   {
      this.codigo_ubicacion = codigo_ubicacion;
   }

   public java.lang.String getObservaciones()
   {
      return this.observaciones;
   }

   public void setObservaciones(java.lang.String observaciones)
   {
      this.observaciones = observaciones;
   }

   public java.lang.String getDirector_solicitante()
   {
      return this.director_solicitante;
   }

   public void setDirector_solicitante(java.lang.String director_solicitante)
   {
      this.director_solicitante = director_solicitante;
   }

   public java.lang.String getDirectorio()
   {
      return this.directorio;
   }

   public void setDirectorio(java.lang.String directorio)
   {
      this.directorio = directorio;
   }

   public java.lang.String getDigitalizado()
   {
      return this.digitalizado;
   }

   public void setDigitalizado(java.lang.String digitalizado)
   {
      this.digitalizado = digitalizado;
   }

   public oficio(java.lang.Long id, java.lang.String nro_oficio,
         java.lang.String nro_tramite, java.util.Date fecha_oficio,
         java.lang.String codigo_ubicacion, java.lang.String observaciones,
         java.lang.String director_solicitante, java.lang.String digitalizado,
         java.lang.String directorio)
   {
      this.id = id;
      this.nro_oficio = nro_oficio;
      this.nro_tramite = nro_tramite;
      this.fecha_oficio = corregirFecha(fecha_oficio);
      this.codigo_ubicacion = codigo_ubicacion;
      this.observaciones = observaciones;
      this.director_solicitante = director_solicitante;
      this.digitalizado = digitalizado;
      this.directorio = directorio;
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