# Java E-Commerce Project

This Java project is a simple e-commerce system that allows users to sign in, view products, add items to their cart, and perform basic shopping operations.

## Table of Contents

- [Features](#features)
- [Prerequisites](#prerequisites)
- [Setup](#setup)
- [Usage](#usage)
- [Project Structure](#project-structure)

## Features

- User authentication (Sign In and Sign Up).
- Viewing and searching for products.
- Adding/removing products from the shopping cart.
- Changing the quantity of items in the cart.
- Calculating the total and processing payments.

## Prerequisites

- Java Development Kit (JDK)
- Integrated Development Environment (IDE) such as Eclipse or IntelliJ
- Git (optional)

## Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/meliuos/E-Commerce-Project
## Usage
Run the Main class to start the program.
Follow the on-screen instructions to Sign In or Sign Up.
Navigate through the menu options to interact with the system.
Enjoy exploring and testing the e-commerce functionalities!

##Project Structure
Main.java: The main entry point of the program.
Person.java, Customer.java, Admin.java: Classes representing users.
Product.java, Electronics.java, Khodhra.java: Classes representing products.
Category.java: Class representing product categories.
InventoryManager.java: Class handling product inventory.
PersonManagement.java: Class managing user authentication and management.
InvalidAmountException.java : Exception class for managing custom exception (note that i used for other purposes not only for Invalid amounts).
Order.java : Class Handling orders of the customers .
Cart.java : Class for managing the cart of a customer .
CartItem.java : Class that is related to product and Cart to connect both of them and make the whole Project connected and works together to accomplish a certain the objectif of this E-Commerce project .
PaymentMethode : Interface for handling the PayPalPayment and CreditCard Payment classes .
Discount.java : Class for the discounts (PercentageDiscount.java,Fixed amount Discount).
Promotion.java : Class to manipulate the discount and apply them .
Payment.java : Class for the last step of an order .

