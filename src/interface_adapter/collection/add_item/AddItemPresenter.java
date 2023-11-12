package interface_adapter.collection.add_item;

import use_case.collection.add_item.AddItemOutputBoundary;

public class AddItemPresenter implements AddItemOutputBoundary {

    private final AddItemViewModel addItemViewModel;

    public AddItemPresenter(AddItemViewModel addItemViewModel) {
        this.addItemViewModel = addItemViewModel;
    }

    @Override
    public void prepareSuccessView() {

    }

    @Override
    public void prepareFailView(String error) {
        AddItemState addItemState = addItemViewModel.getState();
        addItemState.setAddItemError(error);
        addItemViewModel.firePropertyChanged();
    }
}
