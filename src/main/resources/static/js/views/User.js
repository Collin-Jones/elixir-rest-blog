export default function ProfileIndex(props) {
    // language=HTML
    return `
        <header>
            <h1>Profile</h1>
        </header>
        <main>
            <form>
                <label for="username">Username</label>
                <input disabled id="username" name="username" value="${props.user.username}" type="text"/>
                <label for="email">Email</label>
                <input disabled id="email" name="email" value="${props.user.email}" type="text"/>
                <p>
                    ${props.user.username}
                </p>
                <p>
                    ${props.user.password}
                </p>
                <p>
                    ${props.user.email}
                </p>
            </form>
        </main>
    `;
}