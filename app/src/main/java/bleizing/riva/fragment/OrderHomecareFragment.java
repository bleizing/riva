package bleizing.riva.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bleizing.riva.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderHomecareFragment extends Fragment {


    public OrderHomecareFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order_homecare, container, false);
    }

}
