export default function ProfileIndex(props) {
    // language=HTML
    return `
        <header>
            <h1>Profile</h1>
        </header>
        <main>
            <div>
                <p>
                    ${props.user.username}
                </p>
                <p>
                    ${props.user.password}
                </p>
                <p>
                    ${props.user.email}
                </p>
            </div>
        </main>
    `;
}