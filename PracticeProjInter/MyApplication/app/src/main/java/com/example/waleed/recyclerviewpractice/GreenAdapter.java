package com.example.waleed.recyclerviewpractice;

import android.nfc.Tag;
import android.support.v7.widget.RecyclerView;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by waleed on 11/11/2017.
 */
// TODO (4) From GreenAdapter, extend RecyclerView.Adapter<NumberViewHolder>
public class GreenAdapter extends RecyclerView.Adapter<GreenAdapter.NumberViewHolder> {

    private static final String TAG =GreenAdapter.class.getSimpleName();
    private final ListItemClickListner mOnCLickListner;
    // TODO 2(3) Create a final private ListItemClickListener called mOnClickListener
//final private ListItemClickListner mOnCLickListner;

    // TODO (1) Add a private int variable called mNumberItems
private int mNumberItems;
    // TODO (2) Create a constructor for GreenAdapter that accepts an int as a parameter for numberOfItems


    // TODO (3) Store the numberOfItems parameter in mNumberItems

    // TODO (5) Override the onCreateViewHolder method




     /*
     * The number of ViewHolders that have been created. Typically, you can figure out how many
     * there should be by determining how many list items fit on your screen at once and add 2 to 4
     * to that number. That isn't the exact formula, but will give you an idea of how many
     * ViewHolders have been created to display any given RecyclerView.
     *
     * Here's some ASCII art to hopefully help you understand:
     *
     *    ViewHolders on screen:
     *
     *        *-----------------------------*
     *        |         ViewHolder index: 0 |
     *        *-----------------------------*
     *        |         ViewHolder index: 1 |
     *        *-----------------------------*
     *        |         ViewHolder index: 2 |
     *        *-----------------------------*
     *        |         ViewHolder index: 3 |
     *        *-----------------------------*
     *        |         ViewHolder index: 4 |
     *        *-----------------------------*
     *        |         ViewHolder index: 5 |
     *        *-----------------------------*
     *        |         ViewHolder index: 6 |
     *        *-----------------------------*
     *        |         ViewHolder index: 7 |
     *        *-----------------------------*
     *
     *    Extra ViewHolders (off screen)
     *
     *        *-----------------------------*
     *        |         ViewHolder index: 8 |
     *        *-----------------------------*
     *        |         ViewHolder index: 9 |
     *        *-----------------------------*
     *        |         ViewHolder index: 10|
     *        *-----------------------------*
     *        |         ViewHolder index: 11|
     *        *-----------------------------*
     *
     *    Total number of ViewHolders = 11
     */

    private static int viewHolderCount;


    // TODO (1) Add an interface called ListItemClickListener
    public interface ListItemClickListner{
        void onListItemClickListner(int clickedItemIndex);
    }
    // TODO (2) Within that interface, define a void method called onListItemClick that takes an int as a parameter

    // TODO (4) Add a ListItemClickListener as a parameter to the constructor and store it in mOnClickListener
    /**
     * Constructor for GreenAdapter that accepts a number of items to display and the specification
     * for the ListItemClickListener.
     *
     * @param numberOfItems Number of items to display in list
     */
    public GreenAdapter(int numberOfItems,ListItemClickListner listner) {
        mOnCLickListner=listner;
        mNumberItems = numberOfItems;
        viewHolderCount = 0;
    }



    @Override
    public NumberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       Context context=parent.getContext();
        int layoutIdForListItem=R.layout.number_list_item;
        LayoutInflater inflater=LayoutInflater.from(context);
        boolean shouldAttachTOParentImmediately=false;

        View view=inflater.inflate(layoutIdForListItem,parent,shouldAttachTOParentImmediately);
        NumberViewHolder viewHolder=new NumberViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NumberViewHolder holder, int position) {
        Log.d(TAG,"#"+position);
        holder.bind(position);
    }

    // TODO (6) Create and return a new NumberViewHolder within this method

    // TODO (7) Override onBindViewHolder

    // TODO (8) Within onBindViewHolder, call holder.bind and pass in the position

    // TODO (9) Override getItemCount and return the number of items to display

    @Override
    public int getItemCount() {
        return mNumberItems;
    }

    /**
     * Cache of the children views for a list item.
     */








    // TODO (12) Create a class called NumberViewHolder that extends RecyclerView.ViewHolder
    public class NumberViewHolder extends RecyclerView.ViewHolder
    implements View.OnClickListener{
TextView viewHolderIndex;

        // TODO (13) Within NumberViewHolder, create a TextView variable called listItemNumberView

        TextView listItemNumberView;
        private ListItemClickListner mOnCLickListner;
        // TODO (14) Create a constructor for NumberViewHolder that accepts a View called itemView as a parameter

        public NumberViewHolder(View itemView) {
            super(itemView);
            listItemNumberView=(TextView)itemView.findViewById(R.id.tv_item_number);
            viewHolderIndex = (TextView) itemView.findViewById(R.id.tv_view_holder_instance);
            itemView.setOnClickListener(this);
        }

        // TODO (15) Within the constructor, call super(itemView) and then find listItemNumberView by ID

        // TODO (16) Within the NumberViewHolder class, create a void method called bind that accepts an int parameter called listIndex
        public void bind(int listIndex){
            listItemNumberView.setText(String.valueOf(listIndex));
        }

        @Override
        public void onClick(View view) {
            int clickedPosition=getAdapterPosition();
            mOnCLickListner.onListItemClickListner(clickedPosition);
        }
        // TODO (17) Within bind, set the text of listItemNumberView to the listIndex
        // TODO (18) Be careful to get the String representation of listIndex, as using setText with an int does something different

    }
}
