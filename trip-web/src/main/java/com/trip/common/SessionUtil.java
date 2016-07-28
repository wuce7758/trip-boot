package com.trip.common;

import com.trip.context.WebContext;
import com.trip.model.SysResource;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * session工具类
 */
public class SessionUtil {

    public static void setMenu(List<SysResource> menus) {
        setAttr(Constants.SESSION_MENU_FIELD, menus);
    }

    public static void setAttr(String key, Object value) {
        HttpSession session = WebContext.getSession();
        if (null != session) {
            session.setAttribute(key, value);
        }
    }

    public static <T> T getAttr(String key) {
        HttpSession session = WebContext.getSession();
        if (null != session) {
            Object object = session.getAttribute(key);
            if (null != object) {
                return (T) object;
            }
        }
        return null;
    }

}
