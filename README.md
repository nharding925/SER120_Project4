# SER120 Project 4

An interactive Java ball simulation built for my sophomore Software Engineering class (SER120).

## What It Does

A black canvas where you can spawn balls with different behaviors using buttons at the bottom:

- **Shiny** — ball slowly cycles through colors over time
- **Draggable** — click and drag the ball around the screen
- **Moving** — ball bounces around the canvas on its own
- **Splitting** — click the ball and it splits into two smaller balls (if large enough)
- **Outline** — ball renders with a black outline
- **Shrinking** — ball slowly shrinks until it disappears
- **Draggable + Shrinking** — combine drag and shrink behaviors
- **Shrinking + Shiny** — combine shrink and color-cycling behaviors

## How It Works

Uses a **composition over inheritance** design pattern. The `Ball` class is `final` and cannot be extended. Instead, behaviors are added by passing `Component` objects into the Ball constructor. Each component implements an interface with hooks for `update()`, `mousePressed()`, `mouseDragged()`, and `draw()`.

## Built With

- Java
- Java Swing (no external libraries)
- Eclipse IDE

## Course

SER120 — Software Engineering, Sophomore Year
