package com.example.accuceries;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator;

public class MainActivity extends AppCompatActivity {

    private ArrayList<GroceryItem> groceryItems;

    private RecyclerView rvGroceryItems;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ItemTouchHelper itemTouchHelper;
    private GroceryItem deletedItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemTouchHelper = new ItemTouchHelper(simpleCallback);
        groceryItems = new ArrayList<>();

        groceryItems.add(new GroceryItem("Maize Brown Bread Loaf 600g",
                "https://www.shoprite.co.za/medias/10794510EA-checkers515Wx515H.webp?context=bWFzdGVyfGltYWdlc3w0NTk4OHxpbWFnZS93ZWJwfGltYWdlcy9oY2EvaGFkLzEwMTczMzQ5ODIyNDk0LndlYnB8ZmI1NWViYTc0YmU3MjNhZmJkYzkxOGU3Mzk0OTQyMzE2MzQ4MjJkZmEwNjVlMjYyNmE3YWY0ODdhMjRmMTU1NA",
                9.99, 4));
        groceryItems.add(new GroceryItem("Farmer's Choice Frozen Chicken Mixed Portions 5kg",
                "https://www.shoprite.co.za/medias/10248591EA-checkers515Wx515H.webp?context=bWFzdGVyfGltYWdlc3wzNDI4MnxpbWFnZS93ZWJwfGltYWdlcy9oMTYvaGFlLzEwMTA1MDc2MDIzMzI2LndlYnB8Y2E0YmVmZjNiMTQ4MjAyZDBkYzFmZmNlZGJlMDJhNThhYzhlYzQ3NTZmMTQ0NzhmNjY5NzY1Mjk3YzRhNTBkNA",
                179.99, 1));
        groceryItems.add(new GroceryItem("Koo Baked Beans In Tomato Sauce 410g",
                "https://www.shoprite.co.za/medias/10126789EA-20190726-Media-checkers515Wx515H.webp?context=bWFzdGVyfGltYWdlc3wzMTI3MnxpbWFnZS93ZWJwfGltYWdlcy9oYjIvaDZjLzkwMDQ5NzUyOTI0NDYud2VicHxmM2YxYThjMzFjNmI0YTAwMjFhZGRlN2UwZDY3N2Y1OTM3YzJlNWVmOWI2NGEyNGIwMjcyMTI1ZjdkYWVkZTM3",
                16.99, 6));
        groceryItems.add(new GroceryItem("Nestlé Cremora Coffee Creamer Box 750g",
                "https://www.shoprite.co.za/medias/10126789EA-20190726-Media-checkers515Wx515H.webp?context=bWFzdGVyfGltYWdlc3wzMTI3MnxpbWFnZS93ZWJwfGltYWdlcy9oYjIvaDZjLzkwMDQ5NzUyOTI0NDYud2VicHxmM2YxYThjMzFjNmI0YTAwMjFhZGRlN2UwZDY3N2Y1OTM3YzJlNWVmOWI2NGEyNGIwMjcyMTI1ZjdkYWVkZTM3",
                49.99, 3));
        groceryItems.add(new GroceryItem("Spinach Bunch",
                "https://www.shoprite.co.za/medias/10151614EA-20190726-Media-checkers515Wx515H.webp?context=bWFzdGVyfGltYWdlc3wzOTM4MHxpbWFnZS93ZWJwfGltYWdlcy9oYTEvaDU1Lzg5OTg0OTI0NzEzMjYud2VicHwzMzI3ZTBlNjkyZjFkYTZlODA3NGYxYmExYWQxM2Y2NWJhYzJiNDFiZTMwZDMxNmJmMWIxOTA5ODYyNDBjMmMz",
                14.99, 1));
        groceryItems.add(new GroceryItem("Simba KFC Zinger Wings Flavour Potato Chips 120g",
                "https://www.shoprite.co.za/medias/10151614EA-20190726-Media-checkers515Wx515H.webp?context=bWFzdGVyfGltYWdlc3wzOTM4MHxpbWFnZS93ZWJwfGltYWdlcy9oYTEvaDU1Lzg5OTg0OTI0NzEzMjYud2VicHwzMzI3ZTBlNjkyZjFkYTZlODA3NGYxYmExYWQxM2Y2NWJhYzJiNDFiZTMwZDMxNmJmMWIxOTA5ODYyNDBjMmMz",
                19.99, 2));
        groceryItems.add(new GroceryItem("Sunfoil Pure Sunflower Seed Oil 750ml",
                "https://www.shoprite.co.za/medias/10130356EA-checkers515Wx515H.webp?context=bWFzdGVyfGltYWdlc3wyMDAxOHxpbWFnZS93ZWJwfGltYWdlcy9oMjcvaGU1LzEwMjQ4NTg3Mzc4NzE4LndlYnB8NjAzNTVkZTg1YWE5MzUxMTk2NDU0ZTBjNzk3YWZhNGJkZjM5NjQxY2I2NTlmOTZmZDIyZDQ5MWE4MGFjOGRmMw",
                39.99, 5));
        groceryItems.add(new GroceryItem("Maize Brown Bread Loaf 600g",
                "https://www.shoprite.co.za/medias/10794510EA-checkers515Wx515H.webp?context=bWFzdGVyfGltYWdlc3w0NTk4OHxpbWFnZS93ZWJwfGltYWdlcy9oY2EvaGFkLzEwMTczMzQ5ODIyNDk0LndlYnB8ZmI1NWViYTc0YmU3MjNhZmJkYzkxOGU3Mzk0OTQyMzE2MzQ4MjJkZmEwNjVlMjYyNmE3YWY0ODdhMjRmMTU1NA",
                9.99, 4));
        groceryItems.add(new GroceryItem("Farmer's Choice Frozen Chicken Mixed Portions 5kg",
                "https://www.shoprite.co.za/medias/10248591EA-checkers515Wx515H.webp?context=bWFzdGVyfGltYWdlc3wzNDI4MnxpbWFnZS93ZWJwfGltYWdlcy9oMTYvaGFlLzEwMTA1MDc2MDIzMzI2LndlYnB8Y2E0YmVmZjNiMTQ4MjAyZDBkYzFmZmNlZGJlMDJhNThhYzhlYzQ3NTZmMTQ0NzhmNjY5NzY1Mjk3YzRhNTBkNA",
                179.99, 1));
        groceryItems.add(new GroceryItem("Koo Baked Beans In Tomato Sauce 410g",
                "https://www.shoprite.co.za/medias/10126789EA-20190726-Media-checkers515Wx515H.webp?context=bWFzdGVyfGltYWdlc3wzMTI3MnxpbWFnZS93ZWJwfGltYWdlcy9oYjIvaDZjLzkwMDQ5NzUyOTI0NDYud2VicHxmM2YxYThjMzFjNmI0YTAwMjFhZGRlN2UwZDY3N2Y1OTM3YzJlNWVmOWI2NGEyNGIwMjcyMTI1ZjdkYWVkZTM3",
                16.99, 6));
        groceryItems.add(new GroceryItem("Nestlé Cremora Coffee Creamer Box 750g",
                "https://www.shoprite.co.za/medias/10126789EA-20190726-Media-checkers515Wx515H.webp?context=bWFzdGVyfGltYWdlc3wzMTI3MnxpbWFnZS93ZWJwfGltYWdlcy9oYjIvaDZjLzkwMDQ5NzUyOTI0NDYud2VicHxmM2YxYThjMzFjNmI0YTAwMjFhZGRlN2UwZDY3N2Y1OTM3YzJlNWVmOWI2NGEyNGIwMjcyMTI1ZjdkYWVkZTM3",
                49.99, 3));
        groceryItems.add(new GroceryItem("Spinach Bunch",
                "https://www.shoprite.co.za/medias/10151614EA-20190726-Media-checkers515Wx515H.webp?context=bWFzdGVyfGltYWdlc3wzOTM4MHxpbWFnZS93ZWJwfGltYWdlcy9oYTEvaDU1Lzg5OTg0OTI0NzEzMjYud2VicHwzMzI3ZTBlNjkyZjFkYTZlODA3NGYxYmExYWQxM2Y2NWJhYzJiNDFiZTMwZDMxNmJmMWIxOTA5ODYyNDBjMmMz",
                14.99, 1));
        groceryItems.add(new GroceryItem("Simba KFC Zinger Wings Flavour Potato Chips 120g",
                "https://www.shoprite.co.za/medias/10151614EA-20190726-Media-checkers515Wx515H.webp?context=bWFzdGVyfGltYWdlc3wzOTM4MHxpbWFnZS93ZWJwfGltYWdlcy9oYTEvaDU1Lzg5OTg0OTI0NzEzMjYud2VicHwzMzI3ZTBlNjkyZjFkYTZlODA3NGYxYmExYWQxM2Y2NWJhYzJiNDFiZTMwZDMxNmJmMWIxOTA5ODYyNDBjMmMz",
                19.99, 2));
        groceryItems.add(new GroceryItem("Sunfoil Pure Sunflower Seed Oil 750ml",
                "https://www.shoprite.co.za/medias/10130356EA-checkers515Wx515H.webp?context=bWFzdGVyfGltYWdlc3wyMDAxOHxpbWFnZS93ZWJwfGltYWdlcy9oMjcvaGU1LzEwMjQ4NTg3Mzc4NzE4LndlYnB8NjAzNTVkZTg1YWE5MzUxMTk2NDU0ZTBjNzk3YWZhNGJkZjM5NjQxY2I2NTlmOTZmZDIyZDQ5MWE4MGFjOGRmMw",
                39.99, 5));

        rvGroceryItems = findViewById(R.id.rvGroceryList);
        rvGroceryItems.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new GroceryItemAdapter(groceryItems, this);

        rvGroceryItems.setLayoutManager(layoutManager);
        rvGroceryItems.setAdapter(adapter);
        itemTouchHelper.attachToRecyclerView(rvGroceryItems);


    }

    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            int position = viewHolder.getBindingAdapterPosition();
            if (direction == ItemTouchHelper.LEFT) {
                deletedItem = groceryItems.get(position);
                groceryItems.remove(position);
                adapter.notifyItemRemoved(position);

                Snackbar.make(rvGroceryItems, deletedItem.getName(), BaseTransientBottomBar.LENGTH_LONG).setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        groceryItems.add(position, deletedItem);
                        adapter.notifyItemInserted(position);
                    }
                }).show();
            }
        }

        @Override
        public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
            new RecyclerViewSwipeDecorator.Builder(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                    .addBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.red))
                    .addActionIcon(R.drawable.delete_24)
                    .create()
                    .decorate();
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }
    };
}