package fr.hermancia.poec.examen.json_views;

public class JsonViews {


    public interface BrandView {}


    public interface UserListView extends ListingView{}

    public interface ListingView {}

    public interface ModelView extends BrandView{}


}
