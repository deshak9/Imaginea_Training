/*
 *
 */
package com.pramati;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/27/2016
 */
@Controller
public class MyController
{
    @RequestMapping(value = {"/wc**"}, method = RequestMethod.GET)
    public ModelAndView welcomePage()
    {
        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Hello World");
        model.addObject("message", "This is welcome page!");
        model.setViewName("hello");
        return model;
    }
}
