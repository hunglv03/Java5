package com.example.java5.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {
    @Autowired
    HttpSession session;

    /**
     * Đọc giá trị của attribute trong session
     *
     * @param name tên attribute
     * @return giá trị đọc được hoặc null nếu không tồn tại
     */
    public <T> T get(String name, String p) {
        return (T) session.getAttribute(name);
    }

    public <T> T get2(String name) {
        if (session.getAttribute(name) != null)
            return (T) session.getAttribute(name);
        else
            return null;
    }

    /**
     * Thay đổi hoặc tạo mới attribute trong session
     *
     * @param name  tên attribute
     * @param value giá trị attribute
     */
    public void set(String name, Object value) {
        session.setAttribute(name, value);
    }

    /**
     * Xóa attribute trong session
     *
     * @param name tên attribute cần xóa
     */
    public void remove(String name) {
        session.removeAttribute(name);
    }

}
