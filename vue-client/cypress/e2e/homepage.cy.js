describe('The Home Page', () => {
  const user = 'myuser'
  const auth_password ='password'
  beforeEach(() => {
    cy.visit('http://localhost:8080/')
    cy.origin(
      "http://localhost:8180",
      { args: { user, auth_password } },
      ({ user, auth_password }) => {
        cy.get("#username")
          .type(user)
          .get("#password")
          .type(auth_password);
        cy.get("#kc-login").click();
     });
  });

  it('successfully login to homepage', () => {
    cy.get('h1').should('contain', 'Exp-Spring Client')
  })

  it('showing current username', () => {
    cy.get('div.username').should('contain', user)
  })
})