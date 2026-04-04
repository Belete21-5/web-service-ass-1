package com.ShapeTool.shape;

import com.ShapeTool.shape.generated.*; // These are created by the JAXB plugin
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ShapeToolEndpoint {
    private static final String NAMESPACE_URI = "http://woldia.edu/shapetool";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CircleAreaRequest")
    @ResponsePayload
    public CircleAreaResponse getCircleArea(@RequestPayload CircleAreaRequest request) {
        CircleAreaResponse response = new CircleAreaResponse();
        // Area = PI * r^2
        response.setArea(Math.PI * Math.pow(request.getRadius(), 2));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "SquareAreaRequest")
    @ResponsePayload
    public SquareAreaResponse getSquareArea(@RequestPayload SquareAreaRequest request) {
        SquareAreaResponse response = new SquareAreaResponse();
        // Area = side * side
        response.setArea(Math.pow(request.getSide(), 2));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "RectangleAreaRequest")
    @ResponsePayload
    public RectangleAreaResponse getRectangleArea(@RequestPayload RectangleAreaRequest request) {
        RectangleAreaResponse response = new RectangleAreaResponse();
        // Area = length * width
        response.setArea(request.getLength() * request.getWidth());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ParallelogramAreaRequest")
    @ResponsePayload
    public ParallelogramAreaResponse getParallelogramArea(@RequestPayload ParallelogramAreaRequest request) {
        ParallelogramAreaResponse response = new ParallelogramAreaResponse();
        // Area = base * height
        response.setArea(request.getBase() * request.getHeight());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "TriangleAreaRequest")
    @ResponsePayload
    public TriangleAreaResponse getTriangleArea(@RequestPayload TriangleAreaRequest request) {
        TriangleAreaResponse response = new TriangleAreaResponse();
        // Area = 0.5 * base * height
        response.setArea(0.5 * request.getBase() * request.getHeight());
        return response;
    }
}