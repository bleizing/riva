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
public class RumatFragment extends Fragment {


    public RumatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rumat, container, false);
    }

}
