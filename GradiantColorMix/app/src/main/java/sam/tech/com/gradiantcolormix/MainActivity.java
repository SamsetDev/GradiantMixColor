package sam.tech.com.gradiantcolormix;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Context mContext;

    RelativeLayout mRelativeLayout;
    private RecyclerView mRecyclerView;

    private MyAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the application context
        mContext = getApplicationContext();

        // Change the action bar color
        getSupportActionBar().setBackgroundDrawable(
                new ColorDrawable(Color.parseColor("#FF677589"))
        );

        // Get the widgets reference from XML layout
        mRelativeLayout = (RelativeLayout) findViewById(R.id.rl);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        // Initialize a new String array
        String[] places = {
                "Allahabad",
                "Ahmdabad",
                "Agra",
                "Arunachal Pradesh",
                "Asam",
                "Banaras",
                "Barelly",
                "Jaipur",
                "Jamui",
                "Jharkhand",
                "PratapGrah",
                "Bihar",
                "Begusarai",
                "Kaushambi",
                "Newada",
                "Bharatpur"
        };

        /*
            GridLayoutManager
                A RecyclerView.LayoutManager implementations that lays out items in a grid.
                By default, each item occupies 1 span. You can change it by providing a custom
                GridLayoutManager.SpanSizeLookup instance via setSpanSizeLookup(SpanSizeLookup).
        */
        /*
            public GridLayoutManager (Context context, int spanCount)
                Creates a vertical GridLayoutManager

            Parameters
                context : Current context, will be used to access resources.
                spanCount : The number of columns in the grid
        */
        // Define a layout for RecyclerView
        mLayoutManager = new GridLayoutManager(mContext,2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // Initialize a new instance of RecyclerView Adapter instance
        mAdapter = new MyAdapter(mContext,places);

        // Set the adapter for RecyclerView
        mRecyclerView.setAdapter(mAdapter);
    }
}
