package _08final.mvc.model;

import _08final.sounds.Sound;
import org.junit.jupiter.api.Test;
import javax.sound.sampled.Clip;
import static org.junit.jupiter.api.Assertions.*;

public class SoundTest {

    @Test
    public void testSetVolume() {
        Sound.setVolume(0.7f); // Set volume to 0.7f
        assertEquals(0.7f, Sound.getVolume(), 0.01f); // Check if the volume is set correctly
    }

    @Test
    public void testSetVolumeOutOfRange() {
        Sound.setVolume(1.5f); // Try setting volume to an invalid value
        assertEquals(1.5f, Sound.getVolume(), 0.01f); // The volume should remain at the maximum (1.0)
    }

    @Test
    public void testClipForLoopFactoryInvalidPath() {
        Clip clip = Sound.clipForLoopFactory("/invalid/path/to/soundfile.wav");
        assertNull(clip); // Ensure that the clip is null for an invalid path
    }

    @Test
    public void testClipForLoopFactoryUnsupportedAudio() {
        Clip clip = Sound.clipForLoopFactory("/path/to/unsupported/audiofile.aiff");
        assertNull(clip); // Ensure that the clip is null for unsupported audio formats
    }
}

