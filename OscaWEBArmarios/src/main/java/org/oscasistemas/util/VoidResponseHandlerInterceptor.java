package org.oscasistemas.util;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.resource.DefaultServletHttpRequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by Portátil1 on 31/05/2017.
 */
public class VoidResponseHandlerInterceptor extends HandlerInterceptorAdapter {

    private static final String voidResponse = "{}";

    @Override
    public void postHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler,
                           final ModelAndView modelAndView) throws IOException {
        // Returned void?
        if (!response.isCommitted()) {
            // Used ModelAndView?
            if (modelAndView != null) {
                return;
            }
            // Access static resource?
            if (DefaultServletHttpRequestHandler.class == handler.getClass()) {
                return;
            }
            response.setStatus(200);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            try (final Writer writer = response.getWriter()) {
                writer.write(voidResponse);
            }
            response.flushBuffer();
        }
    }
}
