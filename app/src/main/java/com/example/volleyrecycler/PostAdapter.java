package com.example.volleyrecycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    List<PostModel> postList;

    public PostAdapter(Context context, List<PostModel> postList) {

        this.postList=postList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.rowitem,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {





        holder.id.setText(Integer.toString(postList.get(position).getId()));
        holder.name.setText( "Name:"+ postList.get(position).getName());
        holder.email.setText("Email:"+ postList.get(position).getEmail());
        holder.mobile_number.setText("Mobile Number:"+ postList.get(position).getMobile_number());
        holder.father_name.setText("Father's Name:"+  postList.get(position).getFather_name());
        holder.mother_name.setText("Mother's Name:"+   postList.get(position).getMother_name());
        holder.blood_group.setText( "Blood Group:"+  postList.get(position).getBlood_group());
        holder.nationality.setText( "Nationality:"+  postList.get(position).getNationality());
        holder.orga.setText( "Organization:"+  postList.get(position).getOrga());
        holder.present_address.setText( "Present Address:"+   postList.get(position).getPresent_address());
        holder.member_type.setText("Member's Type:"+  postList.get(position).getMember_type());
        holder.designation.setText( "Designation:"+ postList.get(position).getDesignation());

    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView id, name, email, mobile_number, father_name, mother_name, blood_group, nationality, orga, present_address, member_type, designation;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            id=itemView.findViewById(R.id.id);
            name=itemView.findViewById(R.id.name);
            email=itemView.findViewById(R.id.email);
            mobile_number=itemView.findViewById(R.id.mobile_number);
            father_name=itemView.findViewById(R.id.father_name);
            mother_name=itemView.findViewById(R.id.mother_name);
            blood_group=itemView.findViewById(R.id.blood_group);
            nationality=itemView.findViewById(R.id.nationality);
            orga=itemView.findViewById(R.id.orga);
            present_address=itemView.findViewById(R.id.present_address);
            member_type=itemView.findViewById(R.id.member_type);
            designation=itemView.findViewById(R.id.designation);

        }
    }
}
