package com.example.homecaremobile;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
public class CustomListAdapter extends BaseAdapter  {

    private List<Bien> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListAdapter(Context aContext,  List<Bien> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_item_layout, null);
            holder = new ViewHolder();
            holder.adresse = (TextView) convertView.findViewById(R.id.adresse);
            holder.ville = (TextView) convertView.findViewById(R.id.ville);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Bien bien = this.listData.get(position);
        holder.adresse.setText(bien.getAdresse());
        holder.ville.setText("Ville: " + bien.getVille());

        return convertView;
    }

    static class ViewHolder {
        TextView adresse;
        TextView ville;
    }
}

