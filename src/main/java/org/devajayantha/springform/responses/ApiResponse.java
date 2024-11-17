package org.devajayantha.springform.responses;

public class ApiResponse<T> {
    private String status; // e.g., "success" or "error"
    private String message; // e.g., "Operation successful" or "Validation failed"
    private T data; // Generic type for the actual payload

    public ApiResponse(String status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    // Static factory methods for easier creation
    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<>("success", message, data);
    }

    public static <T> ApiResponse<T> error(String message, T data) {
        return new ApiResponse<>("error", message, data);
    }

    // Getters and Setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}