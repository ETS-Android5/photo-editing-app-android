package com.example.photoeditingapp_main.Activity_Mainpage;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.photoeditingapp_main.R;
import com.example.photoeditingapp_main._Classes.ExpandableGridView;
import com.example.photoeditingapp_main._Classes.ImageItem;
import com.example.photoeditingapp_main._Classes.SquareImageView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link studio_recent_page#newInstance} factory method to
 * create an instance of this fragment.
 */
public class studio_recent_page extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public studio_recent_page() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment studio_recent_page.
     */
    // TODO: Rename and change types and number of parameters
    public static studio_recent_page newInstance(String param1, String param2) {
        studio_recent_page fragment = new studio_recent_page();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_studio_recent_page, container, false);
    }

    TextView albumAmount;
    TextView textPhoto;
    MaterialButton DeselectButton;
    MaterialButton SelectButton;
    ImageButton imageButtonMore;
    BottomNavigationView bottomNavigationView;
    BottomNavigationView bottomNavigationView2;
    MenuItem menuItem;
    MenuItem menuItemBlank;
    RelativeLayout relativeLayoutTitle;
    RelativeLayout relativeLayoutSelectedImage;
    boolean isFirstSetUp = true;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Create a list of image items
        List<ImageItem> imageItems = new ArrayList<>();
        imageItems.add(new ImageItem(R.drawable.img));
        imageItems.add(new ImageItem(R.drawable.img));
        imageItems.add(new ImageItem(R.drawable.img));
        imageItems.add(new ImageItem(R.drawable.img));
        imageItems.add(new ImageItem(R.drawable.img));
        imageItems.add(new ImageItem(R.drawable.img));
        imageItems.add(new ImageItem(R.drawable.img));
        imageItems.add(new ImageItem(R.drawable.img));
        imageItems.add(new ImageItem(R.drawable.img));
        imageItems.add(new ImageItem(R.drawable.img));
        imageItems.add(new ImageItem(R.drawable.img));
        imageItems.add(new ImageItem(R.drawable.img));
        imageItems.add(new ImageItem(R.drawable.img));
        imageItems.add(new ImageItem(R.drawable.img));
        imageItems.add(new ImageItem(R.drawable.img));
        imageItems.add(new ImageItem(R.drawable.img));
        imageItems.add(new ImageItem(R.drawable.img));
        imageItems.add(new ImageItem(R.drawable.img));
        imageItems.add(new ImageItem(R.drawable.img));
        imageItems.add(new ImageItem(R.drawable.img));
        imageItems.add(new ImageItem(R.drawable.img));
        imageItems.add(new ImageItem(R.drawable.img));
        imageItems.add(new ImageItem(R.drawable.img));
        imageItems.add(new ImageItem(R.drawable.img));
        imageItems.add(new ImageItem(R.drawable.img));
        imageItems.add(new ImageItem(R.drawable.img));
        imageItems.add(new ImageItem(R.drawable.img));
        imageItems.add(new ImageItem(R.drawable.img));

        // Set album amount
        albumAmount = view.findViewById(R.id.amount_photos_text_recent_page);
        textPhoto = view.findViewById(R.id.photos_text_recent_page);

        // Set button deselect
        DeselectButton = view.findViewById(R.id.deselect_button_recent_page);

        // Set button select
        SelectButton = view.findViewById(R.id.select_button_recent_page);

        // Set button more
        imageButtonMore = view.findViewById(R.id.more_button_recent_page);

        // Set relative layout title
        relativeLayoutTitle = view.findViewById(R.id.relativeLayout_studio_recent_page_title);
        relativeLayoutSelectedImage = view.findViewById(R.id.relativeLayout_studio_recent_page_selected_image);

        // Set menu item edit
        bottomNavigationView = requireActivity().findViewById(R.id.bottom_navigation_mainpage);
        bottomNavigationView2 = requireActivity().findViewById(R.id.bottom_navigation_mainpage_selected_image);
        menuItem = bottomNavigationView2.getMenu().getItem(1);
        menuItemBlank = bottomNavigationView2.getMenu().getItem(0);
        menuItemBlank.setEnabled(false);
        menuItemBlank.setVisible(false);

        // Set grid view
        ExpandableGridView gridView = view.findViewById(R.id.grid_view_recent_page);
        _adapter_gridview_account_page adapter = new _adapter_gridview_account_page(getContext(), imageItems);
        gridView.setAdapter(adapter);

        // Item click in grid view
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MaterialCardView cardView = view.findViewById(R.id.cardView_custom_item_gridview_account_page);
                SquareImageView squareImageView = view.findViewById(R.id.imageView_custom_item_gridview_account_page);
                _adapter_gridview_account_page adapter1 = ((_adapter_gridview_account_page) adapterView.getAdapter());

                // Set animation for image selected
                if (!adapter1.getSelected(i)) {
                    startAnimation(squareImageView, cardView);
                    adapter1.setSelected(i, true);
                } else {
                    endAnimation(squareImageView, cardView);
                    adapter1.setSelected(i, false);
                }
                if (adapter1.getPositionSelectedItems().size() != 0) {
                    if(isFirstSetUp) {
                        relativeLayoutTitle.setVisibility(View.INVISIBLE);
                        relativeLayoutSelectedImage.setVisibility(View.VISIBLE);
                        isFirstSetUp = false;
                        showBottomNavSelectImage();
                    }
                    if(adapter1.getPositionSelectedItems().size() == 1) {
                        menuItem.setVisible(true);
                    }
                    else {
                        if(menuItem.isEnabled()) {
                            menuItem.setVisible(false);
                        }
                    }
                    setText(adapter1.getPositionSelectedItems().size(), albumAmount, textPhoto);
                }
                else {
                    relativeLayoutTitle.setVisibility(View.VISIBLE);
                    relativeLayoutSelectedImage.setVisibility(View.INVISIBLE);
                    isFirstSetUp = true;
                    showBottomNavMainPage();
                }
            }
        });

        // Set button more
        imageButtonMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(v.getContext(), v);
                popupMenu.getMenuInflater().inflate(R.menu.more_button_menu, popupMenu.getMenu());

                popupMenu.getMenu().removeItem(R.id.rename_album);
                if (gridView.getNumColumns() == 1) {
                    popupMenu.getMenu().findItem(R.id.zoom_in).setVisible(false);
                } else if (gridView.getNumColumns() == 5) {
                    popupMenu.getMenu().findItem(R.id.zoom_out).setVisible(false);
                } else {
                    popupMenu.getMenu().findItem(R.id.zoom_in).setVisible(true);
                    popupMenu.getMenu().findItem(R.id.zoom_out).setVisible(true);
                }
                // Set icon for popup menu
                popupMenu.setForceShowIcon(true);
                popupMenu.show();

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.zoom_in:
                                gridView.setNumColumns(gridView.getNumColumns() - 2);
                                break;
                            case R.id.zoom_out:
                                gridView.setNumColumns(gridView.getNumColumns() + 2);
                                break;
                            default:
                                break;
                        }
                        return true;
                    }
                });
            }
        });

        // Set button deselect
        DeselectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relativeLayoutTitle.setVisibility(View.VISIBLE);
                relativeLayoutSelectedImage.setVisibility(View.INVISIBLE);

                List<Integer> positionSelectedItems = adapter.getPositionSelectedItems();
                for (int i = 0; i < positionSelectedItems.size(); i++) {
                    View view=gridView.getChildAt(positionSelectedItems.get(i));
                    if (view != null) {
                        endAnimation(view.findViewById(R.id.imageView_custom_item_gridview_account_page), view.findViewById(R.id.cardView_custom_item_gridview_account_page));
                    }
                }
                adapter.clearSelected();
                isFirstSetUp = true;
                showBottomNavMainPage();
            }
        });

        // Set button select
        SelectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Integer> positionDeselectedItems = adapter.getPositionDeselectedItems();
                for (int i = 0; i < positionDeselectedItems.size(); i++) {
                    View view= (View) gridView.getChildAt(positionDeselectedItems.get(i));
                    if (view != null) {
                        startAnimation(view.findViewById(R.id.imageView_custom_item_gridview_account_page), view.findViewById(R.id.cardView_custom_item_gridview_account_page));
                    }
                }
                if(adapter.getPositionSelectedItems().size() == 1){
                    menuItem.setVisible(false);
                }
                adapter.setAllSelected();
                adapter.notifyDataSetChanged();
                setText(adapter.getPositionSelectedItems().size(),albumAmount,textPhoto);
            }
        });

        // Set up  bottom navigation
        BottomNavigationView bottomNavigationView = requireActivity().findViewById(R.id.bottom_navigation_mainpage_selected_image);
        /*bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.edit_photo:
                        break;
                    case R.id.save_photo:
                        break;
                    case R.id.share_photo:
                        break;
                    case R.id.delete_photo:

                }
                return false;
            }
        });*/
    }

    private void setText(int size, TextView albumAmount, TextView textPhoto) {
        String amount = String.valueOf(size);
        albumAmount.setText(amount);
        if (size == 1) {
            textPhoto.setText("Photo Selected");
        }
        else {
            textPhoto.setText("Photos Selected");
        }
    }

    private void showBottomNavSelectImage() {
        bottomNavigationView.setVisibility(View.GONE);
        bottomNavigationView2.setVisibility(View.VISIBLE);
        bottomNavigationView2.setSelectedItemId(R.id.blank);
    }

    private void showBottomNavMainPage() {
        bottomNavigationView.setVisibility(View.VISIBLE);
        bottomNavigationView2.setVisibility(View.GONE);
    }

    // Start animation when select image item
    private void startAnimation(SquareImageView squareImageView, MaterialCardView cardView) {
        squareImageView.setCornerRadius(32);
        ObjectAnimator animator = ObjectAnimator.ofArgb(cardView, "strokeColor", Color.parseColor("#646464"));
        animator.setDuration(100);
        animator.start();
    }

    // End animation when deselect image item
    private void endAnimation(SquareImageView squareImageView, MaterialCardView cardView) {
        squareImageView.setCornerRadius(0);
        ObjectAnimator animator = ObjectAnimator.ofArgb(cardView, "strokeColor", Color.parseColor("#00646464"));
        animator.setDuration(100);
        animator.start();
    }

}