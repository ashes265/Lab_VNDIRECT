package testSpring.service.model;

import java.util.List;

public class Data {
    private List<Derivative> data;
    private int currentPage;
    private int size;
    private int totalPages;
    private int totalElements;


    public Data() {

    }

    public Data(int currentPage, int size, int totalPages, int totalElements, List<Derivative> data) {
        this.currentPage = currentPage;
        this.size = size;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.data = data;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public List<Derivative> getData() {
        return data;
    }

    public void setData(List<Derivative> data) {
        this.data = data;
    }
}
