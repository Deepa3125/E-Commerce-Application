 E-Commerce Application

Overview
The E-Commerce Application is a console-based Java application developed using Object-Oriented Programming (OOP) principles. It simulates online shopping functionality — product management, cart operations, and checkout with real-time price calculation — using `ArrayList` for in-memory data storage, with no external database.

Features
- Product management (view available products and their stock)
- Add products to a shopping cart
- Real-time price calculation as items are added to the cart
- Stock validation to prevent ordering beyond available inventory
- Checkout with final order total

Technologies Used
- Java
- Object-Oriented Programming (OOP)
- Collections Framework (ArrayList)
- Eclipse IDE

Project Structure
```
src/
├── Product.java
├── CartItem.java
└── ECommerceMain.java
```

How to Run
1. Clone the repository.
2. Open the project in Eclipse or any Java IDE.
3. Compile the project.
4. Run `ECommerceMain.java`.
5. Follow the console menu to browse products and manage your cart.

## Key Concepts
- Classes and Objects
- Encapsulation
- Collections (ArrayList for products and cart items)
- Stock/inventory validation logic
- Real-time price calculation
- Menu-driven console design

## Future Enhancements
- Database integration (MySQL) for persistent product/order data
- User authentication and accounts
- Order history and invoice generation
- Discount and coupon logic
- Graphical User Interface (JavaFX/Swing)
