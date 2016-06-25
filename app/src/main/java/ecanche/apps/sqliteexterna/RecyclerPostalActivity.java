package ecanche.apps.sqliteexterna;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerPostalActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<PostalCode> postalCodes;


    private void fillData() {
        postalCodes = DatabaseAccess.getInstance(this).getPostalCodesObject();
    }

    private void fillAdapter() {
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this.postalCodes);
        recyclerView.setAdapter(recyclerViewAdapter);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_postal);

        recyclerView = (RecyclerView) this.findViewById(R.id.rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        this.fillData();
        this.fillAdapter();

    }
}
