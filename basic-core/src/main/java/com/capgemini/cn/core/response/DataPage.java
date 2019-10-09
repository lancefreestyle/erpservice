package com.capgemini.cn.core.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class DataPage {

    /**
     * 总页数
     */
    private int totalPages;

    /**
     * 总记录数
     */
    private long totalElements;

    /**
     * 当前页码
     */
    private int number;

    /**
     * 每页数据行数
     */
    private int size;

    /**
     * 是否第一页
     */
    private boolean first;

    /**
     * 是否最后一页
     */
    private boolean last;

    /**
     * 默认构造函数
     */
    public DataPage() {
    }

    /**
     * 根据参数构造对象
     *
     * @param totalPages    总页数
     * @param totalElements 总记录数
     * @param number        当前页码
     * @param size          每页数据行数
     * @param first         是否第一页
     * @param last          是否最后一页
     */
    public DataPage(int totalPages, long totalElements, int number, int size, boolean first, boolean last) {
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.number = number;
        this.size = size;
        this.first = first;
        this.last = last;
    }

    /**
     * 总页数
     */
    public int getTotalPages() {
        return totalPages;
    }

    /**
     * 总页数
     */
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    /**
     * 总记录数
     */
    public long getTotalElements() {
        return totalElements;
    }

    /**
     * 总记录数
     */
    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    /**
     * 当前页码
     */
    public int getNumber() {
        return number;
    }

    /**
     * 当前页码
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * 每页数据行数
     */
    public int getSize() {
        return size;
    }

    /**
     * 每页数据行数
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * 是否第一页
     */
    public boolean isFirst() {
        return first;
    }

    /**
     * 是否第一页
     */
    public void setFirst(boolean first) {
        this.first = first;
    }

    /**
     * 是否最后一页
     */
    public boolean isLast() {
        return last;
    }

    /**
     * 是否最后一页
     */
    public void setLast(boolean last) {
        this.last = last;
    }
}
