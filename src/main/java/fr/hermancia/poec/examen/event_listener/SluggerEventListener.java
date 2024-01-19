package fr.hermancia.poec.examen.event_listener;

import fr.hermancia.poec.examen.entity.interfaces.SluggerInterface;
import fr.hermancia.poec.examen.utils.Slugger;
import lombok.AllArgsConstructor;
import org.hibernate.event.spi.PreInsertEvent;
import org.hibernate.event.spi.PreInsertEventListener;
import org.hibernate.event.spi.PreUpdateEvent;
import org.hibernate.event.spi.PreUpdateEventListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SluggerEventListener
        implements
        PreInsertEventListener,
        PreUpdateEventListener {

    private Slugger slugger;
    @Override
    public boolean onPreInsert(PreInsertEvent preInsertEvent) {
        return hasSlugify(preInsertEvent.getEntity());
    }



    @Override
    public boolean onPreUpdate(PreUpdateEvent preUpdateEvent) {
        return hasSlugify(preUpdateEvent.getEntity());
    }
    private boolean hasSlugify(Object entity) {
        if (entity instanceof SluggerInterface sluggerInterface) {
            if (sluggerInterface.getField() == null) {
                return true;
            }
            sluggerInterface.setSlug(slugger.slugify(sluggerInterface.getField()));
        }
        return false;
    }

}
