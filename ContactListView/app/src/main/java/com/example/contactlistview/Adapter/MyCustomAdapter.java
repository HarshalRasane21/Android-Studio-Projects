package com.example.contactlistview.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.contactlistview.ModelClass.contact;
import com.example.contactlistview.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MyCustomAdapter extends ArrayAdapter<contact> {

    private ArrayAdapter<contact> contactArrayAlist;

    Context context;

    public MyCustomAdapter(@NotNull Context context, ArrayList<contact> contactArrayList){
        super(context, R.layout.contacttemplateadapter, contactArrayList);

        this.context=context;
    }

    private static class MyViewHolder{
        TextView contactname;

        TextView phoneno;

        ImageView image;
    }


    public  View getView(int position, View convertView, ViewGroup parent){
        contact contact=getItem(position);

        MyViewHolder myViewHolder;
        final View result;

        if (convertView==null){
            myViewHolder= new MyViewHolder();
            LayoutInflater inflater=LayoutInflater.from(context);
            convertView= inflater.inflate(R.layout.contacttemplateadapter, parent, false);

            myViewHolder.contactname=convertView.findViewById(R.id.name);
            myViewHolder.phoneno=convertView.findViewById(R.id.phoneno);
            myViewHolder.image=convertView.findViewById(R.id.image);
            result =convertView;

            convertView.setTag(myViewHolder);
        }else {
            myViewHolder= (MyViewHolder)  convertView.getTag();
            result = convertView;

        }
        myViewHolder.contactname.setText(contact.getName());
        myViewHolder.phoneno.setText(contact.getPhoneno());
        myViewHolder.image.setImageResource(contact.getImage());
        return result;
    }
}
