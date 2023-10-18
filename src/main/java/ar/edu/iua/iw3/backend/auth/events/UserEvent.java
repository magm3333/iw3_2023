package ar.edu.iua.iw3.backend.auth.events;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserEvent extends ApplicationEvent {
	private static final long serialVersionUID = 1L;
	public enum TypeEvent {
		LOGIN,
		SEND_EMAIL_WITH_PASSWORD_RESTORED,
		SEND_EMAIL_WITH_USERNAME
	}
	public UserEvent(Object source, Object extraData, TypeEvent typeEvent) {
		super(source);
		this.typeEvent = typeEvent;
		this.extraData=extraData;
	}
	private TypeEvent typeEvent;
	private Object extraData;
}

