package common.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

/**
 * @param onUsernameOrImageClick should show user profile on this event
 */
@Composable
fun UserShortInfoView(
    modifier: Modifier = Modifier,
    username: String,
    avatarLink: String,
    onUsernameOrImageClick:()->Unit,
) {

    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {

        AsyncImage(
            model = avatarLink,
            contentDescription = "user image",
            modifier = Modifier
                .size(30.dp)
                .clip(CircleShape)
                .clickable {
                    onUsernameOrImageClick()
                }
        )
        Spacer(Modifier.width(4.dp))
        Text(
            modifier = Modifier.clickable { onUsernameOrImageClick() },
            text = username,
        )
    }

}