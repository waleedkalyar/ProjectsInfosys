package com.example.waleed.recyclerviewpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // TODO (1) Create a private static final int called NUM_LIST_ITEMS and set it equal to 100
private static final int NUM_LIST_ITEMS=100;
    // TODO (2) Create a GreenAdapter variable called mAdapter
    GreenAdapter mAdapter;
    // TODO (3) Create a RecyclerView variable called mNumbersList
    RecyclerView mNumberList;
    private Toast mToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO (4) Use findViewById to store a reference to the RecyclerView in mNumbersList
mNumberList=(RecyclerView) findViewById(R.id.rv_numbers);
        // TODO (5) Create a LinearLayoutManager variable called layoutManager
        LinearLayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        // TODO (6) Use setLayoutManager on mNumbersList with the LinearLayoutManager we created above
mNumberList.setLayoutManager(layoutManager);
        // TODO (7) Use setHasFixedSize(true) to designate that the contents of the RecyclerView won't change an item's size
mNumberList.setHasFixedSize(true);
        // TODO (8) Store a new GreenAdapter in mAdapter and pass it NUM_LIST_ITEMS
mAdapter=new GreenAdapter(NUM_LIST_ITEMS, (GreenAdapter.ListItemClickListner) this);
        // TODO (9) Set the GreenAdapter you created on mNumbersList
        mNumberList.setAdapter(mAdapter);
        mNumberList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ListItemClickListener(12);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.recycler_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int itemId = item.getItemId();

        switch (itemId) {
            /*
             * When you click the reset menu item, we want to start all over
             * and display the pretty gradient again. There are a few similar
             * ways of doing this, with this one being the simplest of those
             * ways. (in our humble opinion)
             */
            case R.id.action_refresh:
                // TODO (14) Pass in this as the ListItemClickListener to the GreenAdapter constructor
                mAdapter = new GreenAdapter(NUM_LIST_ITEMS, (GreenAdapter.ListItemClickListner) this);
                mNumberList.setAdapter(mAdapter);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

   // TODO (10) Override ListItemClickListener's onListItemClick method
    // TODO (11) In the beginning of the method, cancel the Toast if it isn't null
    // TODO (12) Show a Toast when an item is clicked, displaying that item number that was clicked
   public void ListItemClickListener(int clickedItemIndex) {
       // COMPLETED (11) In the beginning of the method, cancel the Toast if it isn't null
        /*
         * Even if a Toast isn't showing, it's okay to cancel it. Doing so
         * ensures that our new Toast will show immediately, rather than
         * being delayed while other pending Toasts are shown.
         *
         * Comment out these three lines, run the app, and click on a bunch of
         * different items if you're not sure what I'm talking about.
         */
       if (mToast != null) {
           mToast.cancel();
       }

       // COMPLETED (12) Show a Toast when an item is clicked, displaying that item number that was clicked
        /*
         * Create a Toast and store it in our Toast field.
         * The Toast that shows up will have a message similar to the following:
         *
         *                     Item #42 clicked.
         */
       String toastMessage = "Item #" + clickedItemIndex + " clicked.";
       mToast = Toast.makeText(this, toastMessage, Toast.LENGTH_LONG);

       mToast.show();
   }
}
