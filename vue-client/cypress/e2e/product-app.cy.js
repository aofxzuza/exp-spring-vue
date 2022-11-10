describe('Product App', () => {
  const user = 'myuser';
  const authPassword = 'password';
  const productName = 'TEST Product 100';
  const productPrice = 100;
  beforeEach(() => {
    cy.visit('http://localhost:8080/')
    cy.origin(
      "http://localhost:8180", { args: { user, authPassword } },
      ({ user, authPassword }) => {
        cy.get("#username")
          .type(user)
          .get("#password")
          .type(authPassword);
        cy.get("#kc-login").click();
      });
      cy.wait(500); // wait 0.5 sec
  });
  

  it('Add product', () => {
    cy.get('#productNameInput')
      .type(productName)
      .should('have.value', productName);
    cy.get('#productPriceInput')
      .type(productPrice)
      .should('have.value', productPrice);
    cy.get("#addProductBtn").click();
  })

  it('Show the added product in the list', () => {
      cy.get('.product-list')
      .find('.product-row')
      .last()
      .find('.product-name')
      .should('have.text', productName)
      
      cy.get('.product-list')
      .find('.product-row')
      .last()
      .find('.product-price')
      .should('have.text', productPrice)

      cy.get('.product-list')
      .find('.product-row')
      .last()
      .find('.product-actions button')
      .should('have.text', 'Delete');
  })

  it('Delete the added product', () => {
    cy.get('.product-list')
      .find('.product-row')
      .last()
      .find('.product-actions')
      .find('button')
      .contains('Delete')
      .click();
  })
})