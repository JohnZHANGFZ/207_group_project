package use_case.collection.get_item;

import java.util.List;

public class GetItemInteractor implements GetItemInputBoundary{

    final GetItemDataAccessInterface getItemDataAccessInterface;
    final GetItemOutputBoundary getItemPresenter;

    public GetItemInteractor(GetItemDataAccessInterface getItemDataAccessInterface,
                             GetItemOutputBoundary getItemPresenter) {
        this.getItemDataAccessInterface = getItemDataAccessInterface;
        this.getItemPresenter = getItemPresenter;
    }

    @Override
    public void execute() {
        List<String> items = getItemDataAccessInterface.getItem();
        if (items.isEmpty()) {
            getItemPresenter.prepareFailView("No items found.");
        } else {
            GetItemOutputData getItemOutputData = new GetItemOutputData(items);
            getItemPresenter.prepareSuccessView(getItemOutputData);
        }
    }
}
