package hva.studentportal.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import hva.studentportal.R;
import hva.studentportal.models.Portal;

/**
 * Created by khaled on 06-10-18.
 */

public class PortalAdapter extends RecyclerView.Adapter<PortalAdapter.MyViewHolder> {
    private final List<Portal> portalList;
    private final onItemClickListener listener;

    public interface onItemClickListener {
        void onItemClick(Portal portal);
    }

    public PortalAdapter(List<Portal> portalList, onItemClickListener listener) {
        this.portalList = portalList;
        this.listener = listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.portal_list_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @NonNull
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Portal portal = portalList.get(position);
        holder.portalName.setText(portal.getTitleName());
        holder.bind(portalList.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return portalList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView portalName;

        public MyViewHolder(View view) {
            super(view);
            portalName = view.findViewById(R.id.namePortal);
        }

        public void bind(final Portal portal, final onItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(portal);
                }
            });
        }
    }
}

