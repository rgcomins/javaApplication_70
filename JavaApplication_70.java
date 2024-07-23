package javaapplication_70;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class JavaApplication_70 extends JFrame {
    private final ShapePanel shapePanel;

    public JavaApplication_70() {
        setTitle("Geometric Shape Calculator");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        shapePanel = new ShapePanel();
        add(shapePanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JavaApplication_70 calculator = new JavaApplication_70();
            calculator.setVisible(true);
            calculator.runCalculator();
        });
    }

    private void runCalculator() {
        while (true) {
            String[] options = {"2D Shapes", "3D Shapes", "Exit"};
            int choice = JOptionPane.showOptionDialog(this,
                    "Choose a shape type or exit",
                    "Geometric Shape Calculator",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]);

            if (choice == 0) {
                handle2DShapes();
            } else if (choice == 1) {
                handle3DShapes();
            } else {
                JOptionPane.showMessageDialog(this, "Thank you for using the Geometric Shape Calculator!");
                System.exit(0);
            }
        }
    }

    private void handle2DShapes() {
        String[] shapes = {"Circle", "Rectangle", "Parallelogram", "Square", "Trapezoid", "Triangle"};
        String shape = (String) JOptionPane.showInputDialog(this,
                "Choose a 2D shape",
                "2D Shape Selection",
                JOptionPane.QUESTION_MESSAGE,
                null,
                shapes,
                shapes[0]);

        if (shape != null) {
            switch (shape) {
                case "Circle":
                    handleCircle();
                    break;
                case "Rectangle":
                    handleRectangle();
                    break;
                case "Parallelogram":
                    handleParallelogram();
                    break;
                case "Square":
                    handleSquare();
                    break;
                case "Trapezoid":
                    handleTrapezoid();
                    break;
                case "Triangle":
                    handleTriangle();
                    break;
            }
        }
    }

    private void handle3DShapes() {
        String[] shapes = {"Cube", "Rectangular Solid", "Right Circular Cone", "Right Circular Cylinder", "Sphere", "Square Pyramid"};
        String shape = (String) JOptionPane.showInputDialog(this,
                "Choose a 3D shape",
                "3D Shape Selection",
                JOptionPane.QUESTION_MESSAGE,
                null,
                shapes,
                shapes[0]);

        if (shape != null) {
            switch (shape) {
                case "Cube":
                    handleCube();
                    break;
                case "Rectangular Solid":
                    handleRectangularSolid();
                    break;
                case "Right Circular Cone":
                    handleRightCircularCone();
                    break;
                case "Right Circular Cylinder":
                    handleRightCircularCylinder();
                    break;
                case "Sphere":
                    handleSphere();
                    break;
                case "Square Pyramid":
                    handleSquarePyramid();
                    break;
            }
        }
    }

    private double getValidInput(String prompt) {
        while (true) {
            try {
                String input = JOptionPane.showInputDialog(this, prompt);
                if (input == null) {
                    throw new NumberFormatException();
                }
                double value = Double.parseDouble(input);
                if (value <= 0) {
                    throw new IllegalArgumentException("Value must be positive");
                }
                return value;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void handleCircle() {
        double radius = getValidInput("Enter the radius of the circle");
        double area = Math.PI * radius * radius;
        double perimeter = 2 * Math.PI * radius;
        shapePanel.drawShape("Circle", radius);
        JOptionPane.showMessageDialog(this,
                String.format("Area: %.2f\nPerimeter: %.2f", area, perimeter),
                "Circle Calculations",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void handleRectangle() {
        double length = getValidInput("Enter the length of the rectangle");
        double width = getValidInput("Enter the width of the rectangle");
        double area = length * width;
        double perimeter = 2 * (length + width);
        shapePanel.drawShape("Rectangle", length, width);
        JOptionPane.showMessageDialog(this,
                String.format("Area: %.2f\nPerimeter: %.2f", area, perimeter),
                "Rectangle Calculations",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void handleParallelogram() {
        double base = getValidInput("Enter the base of the parallelogram");
        double height = getValidInput("Enter the height of the parallelogram");
        double side = getValidInput("Enter the side length of the parallelogram");
        double area = base * height;
        double perimeter = 2 * (base + side);
        shapePanel.drawShape("Parallelogram", base, height, side);
        JOptionPane.showMessageDialog(this,
                String.format("Area: %.2f\nPerimeter: %.2f", area, perimeter),
                "Parallelogram Calculations",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void handleSquare() {
        double side = getValidInput("Enter the side length of the square");
        double area = side * side;
        double perimeter = 4 * side;
        shapePanel.drawShape("Square", side);
        JOptionPane.showMessageDialog(this,
                String.format("Area: %.2f\nPerimeter: %.2f", area, perimeter),
                "Square Calculations",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void handleTrapezoid() {
        double base1 = getValidInput("Enter the first base of the trapezoid");
        double base2 = getValidInput("Enter the second base of the trapezoid");
        double height = getValidInput("Enter the height of the trapezoid");
        double side1 = getValidInput("Enter the first side length of the trapezoid");
        double side2 = getValidInput("Enter the second side length of the trapezoid");
        double area = ((base1 + base2) / 2) * height;
        double perimeter = base1 + base2 + side1 + side2;
        shapePanel.drawShape("Trapezoid", base1, base2, height);
        JOptionPane.showMessageDialog(this,
                String.format("Area: %.2f\nPerimeter: %.2f", area, perimeter),
                "Trapezoid Calculations",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void handleTriangle() {
        double base = getValidInput("Enter the base of the triangle");
        double height = getValidInput("Enter the height of the triangle");
        double side1 = getValidInput("Enter the first side length of the triangle");
        double side2 = getValidInput("Enter the second side length of the triangle");
        double area = (base * height) / 2;
        double perimeter = base + side1 + side2;
        shapePanel.drawShape("Triangle", base, height);
        JOptionPane.showMessageDialog(this,
                String.format("Area: %.2f\nPerimeter: %.2f", area, perimeter),
                "Triangle Calculations",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void handleCube() {
        double side = getValidInput("Enter the side length of the cube");
        double volume = Math.pow(side, 3);
        double surfaceArea = 6 * Math.pow(side, 2);
        shapePanel.drawShape("Cube", side);
        JOptionPane.showMessageDialog(this,
                String.format("Volume: %.2f\nSurface Area: %.2f", volume, surfaceArea),
                "Cube Calculations",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void handleRectangularSolid() {
        double length = getValidInput("Enter the length of the rectangular solid");
        double width = getValidInput("Enter the width of the rectangular solid");
        double height = getValidInput("Enter the height of the rectangular solid");
        double volume = length * width * height;
        double surfaceArea = 2 * (length * width + width * height + height * length);
        shapePanel.drawShape("RectangularSolid", length, width, height);
        JOptionPane.showMessageDialog(this,
                String.format("Volume: %.2f\nSurface Area: %.2f", volume, surfaceArea),
                "Rectangular Solid Calculations",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void handleRightCircularCone() {
        double radius = getValidInput("Enter the radius of the base of the cone");
        double height = getValidInput("Enter the height of the cone");
        double volume = (1.0 / 3) * Math.PI * Math.pow(radius, 2) * height;
        double slantHeight = Math.sqrt(Math.pow(radius, 2) + Math.pow(height, 2));
        double surfaceArea = Math.PI * radius * (radius + slantHeight);
        shapePanel.drawShape("RightCircularCone", radius, height);
        JOptionPane.showMessageDialog(this,
                String.format("Volume: %.2f\nSurface Area: %.2f", volume, surfaceArea),
                "Right Circular Cone Calculations",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void handleRightCircularCylinder() {
        double radius = getValidInput("Enter the radius of the base of the cylinder");
        double height = getValidInput("Enter the height of the cylinder");
        double volume = Math.PI * Math.pow(radius, 2) * height;
        double surfaceArea = 2 * Math.PI * radius * (radius + height);
        shapePanel.drawShape("RightCircularCylinder", radius, height);
        JOptionPane.showMessageDialog(this,
                String.format("Volume: %.2f\nSurface Area: %.2f", volume, surfaceArea),
                "Right Circular Cylinder Calculations",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void handleSphere() {
        double radius = getValidInput("Enter the radius of the sphere");
        double volume = (4.0 / 3) * Math.PI * Math.pow(radius, 3);
        double surfaceArea = 4 * Math.PI * Math.pow(radius, 2);
        shapePanel.drawShape("Sphere", radius);
        JOptionPane.showMessageDialog(this,
                String.format("Volume: %.2f\nSurface Area: %.2f", volume, surfaceArea),
                "Sphere Calculations",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void handleSquarePyramid() {
        double base = getValidInput("Enter the base side length of the pyramid");
        double height = getValidInput("Enter the height of the pyramid");
        double volume = (1.0 / 3) * Math.pow(base, 2) * height;
        double slantHeight = Math.sqrt(Math.pow(height, 2) + Math.pow(base / 2, 2));
        double surfaceArea = Math.pow(base, 2) + 2 * base * slantHeight;
        shapePanel.drawShape("SquarePyramid", base, height);
        JOptionPane.showMessageDialog(this,
                String.format("Volume: %.2f\nSurface Area: %.2f", volume, surfaceArea),
                "Square Pyramid Calculations",
                JOptionPane.INFORMATION_MESSAGE);
    }

    class ShapePanel extends JPanel {
        private String currentShape;
        private double[] parameters;
        private boolean is3D;

        public void drawShape(String shape, double... params) {
            currentShape = shape;
            parameters = params;
            is3D = shape.equals("Cube") || shape.equals("RectangularSolid") || 
               shape.equals("RightCircularCone") || shape.equals("RightCircularCylinder") || 
               shape.equals("Sphere") || shape.equals("SquarePyramid");
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Set background color based on shape type
        if (is3D) {
            setBackground(new Color(173, 216, 230)); // Light blue for 3D shapes
        } else {
            setBackground(new Color(255, 182, 193)); // Light red for 2D shapes
        }
            g2d.setColor(Color.BLUE);

            int width = getWidth();
            int height = getHeight();
            int size = Math.min(width, height) - 40;
            int x = (width - size) / 2;
            int y = (height - size) / 2;

            if (currentShape != null) {
                switch (currentShape) {
                    case "Circle":
                        g2d.drawOval(x, y, size, size);
                        break;
                    case "Rectangle":
                        g2d.drawRect(x, y, size, (int) (size * parameters[1] / parameters[0]));
                        break;
                    case "Parallelogram":
                        int[] xPointsParallelogram = {x + size / 4, x + size, x + size * 3 / 4, x};
                        int[] yPointsParallelogram = {y, y, y + size, y + size};
                        g2d.drawPolygon(xPointsParallelogram, yPointsParallelogram, 4);
                        break;
                    case "Square":
                        g2d.drawRect(x, y, size, size);
                        break;
                    case "Trapezoid":
                        int[] xPointsTrapezoid = {x, x + size, x + size * 3 / 4, x + size / 4};
                        int[] yPointsTrapezoid = {y + size, y + size, y, y};
                        g2d.drawPolygon(xPointsTrapezoid, yPointsTrapezoid, 4);
                        break;
                    case "Triangle":
                        int[] xPointsTriangle = {x, x + size, x + size / 2};
                        int[] yPointsTriangle = {y + size, y + size, y};
                        g2d.drawPolygon(xPointsTriangle, yPointsTriangle, 3);
                        break;
                    case "Cube":
                        drawCube(g2d, x, y, size);
                        break;
                    case "RectangularSolid":
                        drawRectangularSolid(g2d, x, y, size);
                        break;
                    case "RightCircularCone":
                        drawRightCircularCone(g2d, x, y, size);
                        break;
                    case "RightCircularCylinder":
                        drawRightCircularCylinder(g2d, x, y, size);
                        break;
                    case "Sphere":
                        drawSphere(g2d, x, y, size);
                        break;
                    case "SquarePyramid":
                        drawSquarePyramid(g2d, x, y, size);
                        break;
                }
            }
        }

        private void drawCube(Graphics2D g2d, int x, int y, int size) {
            int offset = size / 4;
            g2d.drawRect(x + offset, y - offset, size, size);
            g2d.drawRect(x, y, size, size);
            g2d.drawLine(x, y, x + offset, y - offset);
            g2d.drawLine(x + size, y, x + size + offset, y - offset);
            g2d.drawLine(x, y + size, x + offset, y + size - offset);
            g2d.drawLine(x + size, y + size, x + size + offset, y + size - offset);
        }

        private void drawRectangularSolid(Graphics2D g2d, int x, int y, int size) {
            int offset = size / 4;
            int depth = size / 2;
            g2d.drawRect(x, y, size, size / 2);
            g2d.drawRect(x + offset, y - offset, size, size / 2);
            g2d.drawLine(x, y, x + offset, y - offset);
            g2d.drawLine(x + size, y, x + size + offset, y - offset);
            g2d.drawLine(x, y + size / 2, x + offset, y + size / 2 - offset);
            g2d.drawLine(x + size, y + size / 2, x + size + offset, y + size / 2 - offset);
        }

        private void drawRightCircularCone(Graphics2D g2d, int x, int y, int size) {
            int baseHeight = size / 2;
            int baseWidth = size;
            g2d.drawOval(x, y + baseHeight, baseWidth, baseHeight);
            g2d.drawLine(x, y + baseHeight, x + baseWidth / 2, y);
            g2d.drawLine(x + baseWidth, y + baseHeight, x + baseWidth / 2, y);
        }

        private void drawRightCircularCylinder(Graphics2D g2d, int x, int y, int size) {
            int height = size;
            int width = size / 2;
            g2d.drawOval(x, y, width, width / 2);
            g2d.drawOval(x, y + height - width / 2, width, width / 2);
            g2d.drawLine(x, y + width / 4, x, y + height - width / 4);
            g2d.drawLine(x + width, y + width / 4, x + width, y + height - width / 4);
        }

        private void drawSphere(Graphics2D g2d, int x, int y, int size) {
            g2d.drawOval(x, y, size, size);
            int offset = size / 4;
            g2d.drawOval(x + offset, y + offset, size - 2 * offset, size - 2 * offset);
        }

        private void drawSquarePyramid(Graphics2D g2d, int x, int y, int size) {
            int halfSize = size / 2;
            g2d.drawRect(x, y + halfSize, size, halfSize);
            g2d.drawLine(x, y + halfSize, x + size / 2, y);
            g2d.drawLine(x + size, y + halfSize, x + size / 2, y);
        }
    }
}



///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
// */
//package javaapplication_70;
//
///**
// *
// * @author Richard Comins
// */
//public class JavaApplication_70 {
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        // TODO code application logic here
//    }
//    
//}
