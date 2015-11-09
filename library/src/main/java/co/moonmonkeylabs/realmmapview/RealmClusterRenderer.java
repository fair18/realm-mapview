package co.moonmonkeylabs.realmmapview;

import android.content.Context;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.view.DefaultClusterRenderer;

import io.realm.RealmClusterManager;
import io.realm.RealmClusterWrapper;
import io.realm.RealmObject;

public class RealmClusterRenderer<M extends RealmObject>
        extends DefaultClusterRenderer<RealmClusterWrapper<M>> {

    private RealmClusterManager<M> clusterManager;

    public RealmClusterRenderer(
            Context context,
            GoogleMap map,
            RealmClusterManager<M> clusterManager) {
        super(context, map, clusterManager);
        this.clusterManager = clusterManager;
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void onBeforeClusterItemRendered(RealmClusterWrapper person, MarkerOptions markerOptions) {
        super.onBeforeClusterItemRendered(person, markerOptions);
        markerOptions.title(person.getRealmRow().getString(
                clusterManager.getTitleRealmColumnIndex()));
    }
}