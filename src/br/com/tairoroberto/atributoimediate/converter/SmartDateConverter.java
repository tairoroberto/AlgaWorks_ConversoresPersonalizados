package br.com.tairoroberto.atributoimediate.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("br.com.tairorobert.SmartDate")
public class SmartDateConverter implements Converter{
	private static final DateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date getDataHoje(){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Date dataConvertida = null;
		
		if (value != null && !value.equals("")) {
			if (value.equalsIgnoreCase("hoje")) {
				dataConvertida = getDataHoje();
			}else{
				try {
					dataConvertida = formatador.parse(value);
				} catch (ParseException e) {
					//instancia um faces message para ser mostrado
					FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Data incorreta","Informe a uma data correta.");
					//Lança uma exceção para mostrar a mensagem
					throw new ConverterException(message);
				}
			}
		}
		return dataConvertida;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (this.getDataHoje().equals(value)) {
			return "Hoje";
		}
		return formatador.format((Date) value);
	}

}
