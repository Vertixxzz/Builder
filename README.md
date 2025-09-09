# Builder
it's java again ohno

Builder Pattern Implementation in Tech Store System

The goal of this assignment was to implement the Builder pattern in Java, following the principles of Clean Code
I chose a simple Tech Store system with a Product class that represents items like laptops, smartphones, or TVs
This object is a good candidate for the Builder pattern because it has many fields, some required (name, price) and some optional (description, warranty, availability)

The central entity is the Product class with the following fields:
name (String)
category (String)
price (double)
brand (String)
description (String, optional)
warrantyMonths (int, optional)
available (boolean, default = true)
To avoid complex constructors and unsafe setters, I implemented an inner static class Builder inside Product

Example of object creation:

Product laptop = new Product.Builder()
        .withName("ThinkPad X1 Carbon")
        .inCategory("Laptop")
        .withPrice(1599.99)
        .ofBrand("Lenovo")
        .withWarranty(24)
        .build();

The build() method validates critical fields (e.g., product must have a name and valid price)
The result is an immutable object: all fields are final and can only be set through the builder

Clean Code Principles Applied

Meaningful names – methods like withName, withWarranty are self-explanatory
Immutability – Product is read-only after creation (final fields, no setters)
Validation – build() ensures that an object cannot be created in an invalid state
Defaults – available = true makes sense in the store context, but can be changed
Separation of concerns – Product stores data, while Builder handles construction logic

Conlcusion

The builder pattern makes object creation readable, safe, and maintainable, compared to constructors with many parameters or mutable setters

This solution demonstrates both the design pattern and the Clean Code principles, making the system easier to extend in the future (e.g., adding Customer or Order classes with their own builders)
