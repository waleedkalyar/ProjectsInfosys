package com.example.waleed.volleywithgsonpractice.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.waleed.volleywithgsonpractice.R;
import com.example.waleed.volleywithgsonpractice.models.GitHubUsersModel;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserProfilesMenuAdapter extends RecyclerView.Adapter<UserProfilesMenuAdapter.UserProfilesViewHolder> {
    private List<GitHubUsersModel> usersList;

    public interface ListItemClickListner{
        void onListItemClick(GitHubUsersModel clickedUser);
    }


    public UserProfilesMenuAdapter(List<GitHubUsersModel> usersList ){
        this.usersList=usersList;

    }

    @Override
    public UserProfilesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        int LayoutInflatorId=R.layout.user_profile;
        LayoutInflater inflater= LayoutInflater.from(context);
        boolean shouldAttachToParentImediately=false;
        View view=inflater.inflate(LayoutInflatorId,parent,shouldAttachToParentImediately);
        UserProfilesViewHolder profilesViewHolder=new UserProfilesViewHolder(view);
        return profilesViewHolder;
    }

    @Override
    public void onBindViewHolder(UserProfilesViewHolder holder, int position) {
        GitHubUsersModel user = this.usersList.get(position);
        holder.bindUsers(user);
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }


    public class UserProfilesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    CircleImageView imageProfile;
    TextView userNameProfile;


        public UserProfilesViewHolder(View itemView) {
            super(itemView);
            imageProfile=(CircleImageView) itemView.findViewById(R.id.userPhotoProfile);
            userNameProfile=(TextView) itemView.findViewById(R.id.userFirstNameProfile);
            itemView.setOnClickListener(this);
        }

        void bindUsers(GitHubUsersModel user){

            Glide.with(imageProfile.getContext())
                    .load(user.getAvatarUrl())
                    .into(imageProfile);


            userNameProfile.setText(user.getLogin());


        }

        @Override
        public void onClick(View v) {
            int adapterPosition=getAdapterPosition();
            GitHubUsersModel user=usersList.get(adapterPosition);
        }
    }

    public void refill(GitHubUsersModel users) {

        // Add each user and notify recyclerView about change
        usersList.add(users);
        notifyDataSetChanged();
    }
}
